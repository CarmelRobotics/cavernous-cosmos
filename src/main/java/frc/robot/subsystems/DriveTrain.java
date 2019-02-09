package frc.robot.subsystems;



import edu.wpi.first.wpilibj.command.Subsystem;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.SpeedControllerGroup;


import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;




public class DriveTrain extends Subsystem {



	private static Joystick stick;
	private static Joystick stick2;

    private SpeedController motorFLeft;

    private SpeedController motorBLeft;

    private SpeedController motorFRight;

    private SpeedController motorBRight;

    private SpeedControllerGroup motorLeft;

    private SpeedControllerGroup motorRight;

    private DifferentialDrive drive;
	private DifferentialDrive drive2;
        
	private SpeedController motorMiddle;


	private PIDController pid;
	


	private CANSparkMax motorTest;
	private CANEncoder encoder;



    public DriveTrain() {

    	super("Drive Train");

		
    	stick = new Joystick(0);
		stick2 = new Joystick(1);
		motorFLeft = new CANSparkMax (0,MotorType.kBrushless);
		motorFRight = new CANSparkMax (3,MotorType.kBrushless);
	
		motorBLeft = new CANSparkMax (2,MotorType.kBrushless);
		motorBRight = new CANSparkMax (1,MotorType.kBrushless);
		motorMiddle = new CANSparkMax(4,MotorType.kBrushless);
	//motorBLeft = new PWMTalonSRX(1);
    	//motorBLeft = new PWMVictorSPX(1);

    	

    
    	motorLeft = new SpeedControllerGroup(motorFLeft, motorBLeft);

    	motorRight = new SpeedControllerGroup(motorFRight, motorBRight);

    	
		//Two different drives, a separate drive for the left motors and the right motors
    	drive = new DifferentialDrive(motorLeft, motorLeft);
		drive2 = new DifferentialDrive(motorRight, motorRight);
		
		
		motorTest = new CANSparkMax (5,MotorType.kBrushless);
		encoder = motorTest.getEncoder();


    }



	@Override

	protected void initDefaultCommand() {

		// TODO Auto-generated method stub

		

	}
 
	public void arcadeDrive() {
		//Left Side
		//The negatives on this side make sure that the motors are spinning the opposite direction of the right side.
		drive.arcadeDrive(-stick.getX(), -stick.getY(), true);
		//right side
		//The negative stick x makes sure the robot turns in the right direction
		drive2.arcadeDrive(-stick.getX(), stick.getY(), true);

		motorTest.set(stick.getX());
		//SmartDashboard.putNumber("Encoder Position", encoder.getPosition());

	
		//SmartDashboard.putNumber("Encoder Velocity", encoder.getVelocity());

		//System.out.println("Encoder Position" + encoder.getPosition());
		System.out.println("Encoder Velocity" + encoder.getVelocity());

	//	motorFLeft.set(1);
	//motorFLeft.set(.2);
	}






	public void motorForward() {

		//drive.arcadeDrive(stick.getY(), stick.getX(), true);
		motorFLeft.set(.2);
	//	System.out.println("Sub Forward");
	}


	public void motorStop() {

		//drive.arcadeDrive(stick.getY(), stick.getX(), true);
		motorFLeft.stopMotor();
	}


	public void motorBackwards() {

		//drive.arcadeDrive(stick.getY(), stick.getX(), true);
		motorFLeft.set(-.2);
	}

    

}