
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.MoveDrivetrainY;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;


public class DriveTrain extends Subsystem {

	//Declaring Joysticks
	private static Joystick jStick_A;
	private static Joystick jStick_B;
	//Declaring Speed Controllers (Sparks)
    private CANSparkMax motorFLeft;
    private CANSparkMax motorBLeft;
    private CANSparkMax motorFRight;
	private CANSparkMax motorBRight;
	private CANSparkMax motorMiddle;
;
	private SpeedController motorElevator;
	
	//Drive Train Encoders
	private CANEncoder encFLeft;
	private CANEncoder encBLeft;
	private CANEncoder encFRight;
	private CANEncoder encBRight;
	private CANEncoder encMiddle;
	//Declaring Speed Controller Groups
    private SpeedControllerGroup motorLeft;
    private SpeedControllerGroup motorRight;
	//Declaring Drive
	private DifferentialDrive drive;
	private DoubleSolenoid gearShift;
	private Timer time;
	private double startTime;

	
	private Button slowDriveTrain;

	
	//Old. Only use if new doesn't work
	//private DifferentialDrive drive2;
	
	//How to declare encoder
	//private CANEncoder encoder;

    public DriveTrain() {
    	super("Drive Train");
		
		//Contructing Joysticks
    	jStick_A = new Joystick(RobotMap.JOYSTICK_A_ID);
		jStick_B = new Joystick(RobotMap.GUITAR_ID);

		//Contructing Spark Motors
		motorFLeft = new CANSparkMax (RobotMap.CAN_ID_FRONT_LEFT,MotorType.kBrushless);
		motorFRight = new CANSparkMax (RobotMap.CAN_ID_FRONT_RIGHT,MotorType.kBrushless);
		motorBLeft = new CANSparkMax (RobotMap.CAN_ID_BACK_LEFT,MotorType.kBrushless);
		motorBRight = new CANSparkMax (RobotMap.CAN_ID_BACK_RIGHT,MotorType.kBrushless);
		motorMiddle = new CANSparkMax(RobotMap.CAN_ID_DROPWHEEL,MotorType.kBrushless);
		motorElevator = new CANSparkMax(RobotMap.CAN_ID_ELEVATOR,MotorType.kBrushless);
		
		encFLeft = motorFLeft.getEncoder();
		encBLeft = motorFRight.getEncoder();
		encFRight = motorBLeft.getEncoder();
		encBRight = motorBRight.getEncoder();
		encMiddle = motorMiddle.getEncoder();

	

		//Contructing Spark Motor Groups
    	motorLeft = new SpeedControllerGroup(motorFLeft, motorBLeft);
    	motorRight = new SpeedControllerGroup(motorFRight, motorBRight);

		//Constructing the DriveTrain out of Spark Motor Groups
		drive = new DifferentialDrive(motorLeft, motorRight);
		drive.setSafetyEnabled(false);
		//Constructing Solenoid
		
    	gearShift = new DoubleSolenoid(RobotMap.SOLE_GEARSHIFT_HIGH, RobotMap.SOLE_GEARSHIFT_LOW);

	slowDriveTrain = RobotMap.APPROACH_OBJECTIVE_BUTTON;
	time = new Timer();
    }

	@Override
	protected void initDefaultCommand() {
	}
 
	public void arcadeDrive() {

		drive.arcadeDrive(-jStick_A.getY(), jStick_A.getX(), true);

		//Old. Only use if new doesn't work
		//Left Side
		//The negatives on this side make sure that the motors are spinning the opposite direction of the right side.
		//drive.arcadeDrive(-stick.getX(), -stick.getY(), true);
		//right side
		//The negative stick x makes sure the robot turns in the right direction
		//drive2.arcadeDrive(-stick.getX(), stick.getY(), true);
	
		//Printing Encoder values
		//System.out.println("Encoder Position" + encoder.getPosition());
		//System.out.println("Encoder Velocity" + encoder.getVelocity());
	}

	private double expDriveEquation(double joyvalue, double constant) {

		double value;
		
		value = (constant*(Math.pow(joyvalue,3)) + ((1-constant) * joyvalue));

		//System .out.println("full Value " + value);

		//System .out.println("Joyvalue "+ joyvalue);
		return value;
	}



	public void slideDrive(){
		
		//First param is ALWAYS getY. Wheels will seem to spin opposite directions if X is first
		//Slow down if button is pressed
		if(!slowDriveTrain.get()) {

		drive.arcadeDrive(expDriveEquation(-jStick_A.getY(),.3),(.75*expDriveEquation(jStick_A.getZ(),.4)));
		}
			//Move at normal speed
		else {
			drive.arcadeDrive((expDriveEquation(-jStick_A.getY(),.3))/2,((.75*expDriveEquation(jStick_A.getZ(),.4)))/2) ;
		}
	//Setting the middle wheel to the x axis of the second joystick. Allows the slide drive
	//	motorMiddle.set(expDriveEquation(jStick_A.getX(),.65)); //Slows down middle wheel movement
	motorMiddle.set(.8*expDriveEquation(jStick_A.getX(), .6));
	
	  }

	  public void MoveDriveTimer(double timeAmount, double velocity) {
	
		time.start();
		double timeElapsed = time.get();

		
		while((timeElapsed < timeAmount))  {
		//	if(motorFLeft.getOutputCurrent() < 28 || motorFRight.getOutputCurrent() < 28) {
			set4Wheel(velocity, (.75*expDriveEquation(jStick_A.getZ(),.4)));	
		
			System.out.println(timeElapsed);
			timeElapsed = time.get();
			motorMiddle.set(.8*expDriveEquation(jStick_A.getX(), .6));
			System.out.println("Time: " + time.get()+ "Amp: " + motorFLeft.getOutputCurrent());
			//}
		}
		time.stop();
		time.reset();
	}

	  
	public void set4Wheel(double velocity, double rotation){
		drive.arcadeDrive(velocity, rotation);
	}
	
	public void setSlide(double velocity){
		motorMiddle.set(velocity);
  	}
	public void gearshiftHigh() {
		gearShift.set(DoubleSolenoid.Value.kForward);
	}
	public void gearshiftLow() {
		gearShift.set(DoubleSolenoid.Value.kReverse);
	}

	public double getEncoderFLeft() {
		return encFLeft.getPosition();
	}

	public double getEncoderFRight() {
		return encFRight.getPosition();
	}

	public double getEncoderBLeft() {
		return encBLeft.getPosition();
	}

	public double getEncoderBRight() {
		return encBRight.getPosition();
	}

	public double getEncoderMiddle() {
		return encMiddle.getPosition();
	}

	public void moveAccordingToRotations(double rotations) {
		Command moveDistance = new MoveDrivetrainY(rotations);
		moveDistance.start();
	}

}