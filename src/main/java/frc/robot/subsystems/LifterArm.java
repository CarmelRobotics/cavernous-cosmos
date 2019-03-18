
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;



public class LifterArm extends Subsystem {

	private WPI_TalonSRX angler;
	private int startingPos;
	private double currentPos;
	private boolean hasNotMoved;

  //Limit Switches
  	private DigitalInput groundSwitch;
  	private DigitalInput angleSwitch;
  	private DigitalInput topSwitch;
  //Position Tellers
  	public Boolean atBottom;
  	public Boolean atAngle;
  	public Boolean atTop;

	public LifterArm() {

		super("Arm");
		angler = new WPI_TalonSRX(RobotMap.ANGLER_ID);
		startingPos = RobotMap.ARM_STARTING_POSITION;
		hasNotMoved = true;

		angler.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		angler.setSelectedSensorPosition(RobotMap.ARM_STARTING_POSITION, 0, 0);

	}

	@Override
	protected void initDefaultCommand() {
	}

	//For limit switch arm
	public void moveMotorForward() {
  	angler.set(ControlMode.PercentOutput, 1);
	}
	public void moveMotorReverse() {
  	angler.set(ControlMode.PercentOutput, -1);
	}


	public boolean armChangeAngle(double desiredPos) { //This method serves to change the arm's angle to any given angle
		currentPos = -(angler.getSelectedSensorPosition(0)/(4096/360));
		if (currentPos < desiredPos && hasNotMoved) {  //If we need to move the arm up
			armRaiseAngle(currentPos, desiredPos); //calls the method defined below //armRaise
			return false; //movement not finished
		}

		else if (currentPos > desiredPos && hasNotMoved) { //If we need to move the arm down
			armLowerAngle(currentPos, desiredPos); //calls the other method defined below //armLower
			return false; //movement not finished
		}

		else { //if We have reached the desired position
			System.out.println(currentPos);
			armAnglerStop(); //Stop changing the arm angle
			System.out.println("Ok, We are there! Sweet!");
			return true; //movement is finished
		}

	}

	public void manualRaiseAngle() {
		angler.set(ControlMode.PercentOutput, -1);
		
		System.out.println(-angler.getSelectedSensorPosition(0)/(4096/360));
		System.out.println("raising here");

	}

	public void manualLowerAngle() {
		angler.set(ControlMode.PercentOutput, .3);
		System.out.println(-angler.getSelectedSensorPosition(0)/(4096/360));
		System.out.println("lowering here");

	}

	public void armRaiseAngle(double currentPos, double desiredPos)
	{ //Code to raise the arm

		if(desiredPos - currentPos >= 100) //If we are far away from our destination angle old:5
		{
			angler.set(ControlMode.PercentOutput, .8); //.7
		}
		else //If we are close to destination angle (serves to prevent overshooting the angle)
		{
			angler.set(ControlMode.PercentOutput, .5); //.7
		}
		currentPos = -(angler.getSelectedSensorPosition(0)/(4096/360));

		//System.out.println("raising, cp: " + currentPos + " dp: " + desiredPos);
		if (currentPos >= desiredPos || currentPos >= desiredPos + 3 || currentPos >= desiredPos-3) {
			hasNotMoved = false;
		}
	}

	public void armLowerAngle(double currentPos, double desiredPos)
	{ //Code to lower the arm
		if(desiredPos - currentPos <= -50)//If we are far away from our destination angle
		{
			angler.set(ControlMode.PercentOutput, -0.3);
		}
		else//If we are close to destination angle (serves to prevent overshooting the angle)
		{
			angler.set(ControlMode.PercentOutput, -0.2);
		}
		currentPos = -(angler.getSelectedSensorPosition(0)/(4096/360));

		//System.out.println("lowering, cp: " + currentPos + " dp: " + desiredPos);
		if (currentPos <= desiredPos || currentPos <= desiredPos + 3 || currentPos <= desiredPos-3) {
			hasNotMoved = false;
		}
	}

	public void armAnglerStop() {

		angler.set(ControlMode.PercentOutput, 0.0);
		System.out.println("time to stop!");
		hasNotMoved = true;
	}

	public void armStop() {
		angler.stopMotor();
	}

	public int getAnglerPosition() {
		return -(angler.getSelectedSensorPosition(0)/(4096/360));
	}

	public void setAnglerPosition(int pos) {
		angler.setSelectedSensorPosition(pos, 0, 0);
	}

public Boolean getLimitSwitchValue(DigitalInput limitSwitch) {
return limitSwitch.get();
}
public Boolean getGroundSwitch() {
  return groundSwitch.get();
}
public Boolean getAngleSwitch() {
  return angleSwitch.get();
}
public Boolean getTopSwitch() {
  return topSwitch.get();
}
}