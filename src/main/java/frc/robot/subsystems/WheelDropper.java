/*----------------------------------------------------------------------------*/

/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/**
 * Used to drop the center wheel for slide drive.
 */
public class WheelDropper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // Somebody once told me

  //Declaring Solenoid
  private DoubleSolenoid dropper;

  public WheelDropper() {
    //Constructing Solenoid
    dropper = new DoubleSolenoid(RobotMap.WHEELDROP_PCM_ID_UP, RobotMap.WHEELDROP_PCM_ID_DOWN);
 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

//Wheel is initally up so forward puts it down in place
  public void down(){
    dropper.set(DoubleSolenoid.Value.kForward);
    RobotMap.WHEEL_DROPPED = true;
  }
//Wheel is initally up so reverse puts it back in place
  public void up(){

    dropper.set(DoubleSolenoid.Value.kReverse);
    RobotMap.WHEEL_DROPPED = false;
  }

  public void stop(){
    dropper.set(DoubleSolenoid.Value.kOff);

  }

}
