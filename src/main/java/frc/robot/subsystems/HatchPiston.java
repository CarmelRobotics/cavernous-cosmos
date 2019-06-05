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
public class HatchPiston extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // Somebody once told me

  //Declaring Solenoid
  private DoubleSolenoid piston;

  public HatchPiston() {
    //Constructing Solenoid
    piston = new DoubleSolenoid(RobotMap.WHEELDROP_PCM_ID_UP, RobotMap.WHEELDROP_PCM_ID_DOWN);
  //  dropper.set(DoubleSolenoid.Value.kForward);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

//Wheel is initally up so forward puts it down in place
  public void out(){
    piston.set(DoubleSolenoid.Value.kForward);
    RobotMap.WHEEL_DROPPED = true;
  //  System.out.println(piston.get());
  }
//Wheel is initally up so reverse puts it back in place
  public void in(){

    piston.set(DoubleSolenoid.Value.kReverse);
    RobotMap.WHEEL_DROPPED = false;
   // System.out.println(piston.get());
  }

  public void stop(){
    piston.set(DoubleSolenoid.Value.kOff);

  }

}
