package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
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
	

	//Drive Train Encoders
	private CANEncoder motorFLeftEncoder;
	private CANEncoder motorBLeftEncoder;
	private CANEncoder motorBRightEncoder;
	private CANEncoder motorFRightEncoder;
	private CANEncoder motorMiddleEncoder;

	//Declaring Speed Controller Groups
    private SpeedControllerGroup motorLeft;
    private SpeedControllerGroup motorRight;

	//Declaring Drive
	private DifferentialDrive drive;
	private DoubleSolenoid gearShift;


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

		//Contructing Spark Motor Groups
    	motorLeft = new SpeedControllerGroup(motorFLeft, motorBLeft);
    	motorRight = new SpeedControllerGroup(motorFRight, motorBRight);

		//Constructing the DriveTrain out of Spark Motor Groups
		drive = new DifferentialDrive(motorLeft, motorRight);		

		//Constructing Solenoid	
    	gearShift = new DoubleSolenoid(RobotMap.SOLE_GEARSHIFT_HIGH, RobotMap.SOLE_GEARSHIFT_LOW);

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

	public void slideDrive(){
		//First param is ALWAYS getY. Wheels will seem to spin opposite directions if X is first
		drive.arcadeDrive(-jStick_A.getY(), jStick_A.getZ());

		//motorMiddle.setIdleMode(IdleMode.kCoast);
	//Setting the middle wheel to the x axis of the second joystick. Allows the slide drive
		motorMiddle.set(jStick_A.getX());
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

	public void moveAccordingToRotations(double rotations) {
	//Command moveDistance = new MoveDriveTrainRotations(rotations);
	//moveDistance.start();
	}
}