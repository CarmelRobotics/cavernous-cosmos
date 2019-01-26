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
public class WheelDrop extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // Somebody once told me
  
  private DoubleSolenoid dropper;

  public void initialize(){
    dropper = new DoubleSolenoid(RobotMap.DROP_PCM_ID_FW, RobotMap.DROP_PCM_ID_BW);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  public void down(){ //frick
    dropper.set(DoubleSolenoid.Value.kForward);
  }

  public void up(){ // up and away
    
    dropper.set(DoubleSolenoid.Value.kForward);
  }

  public void stop(){ // hammer time
    dropper.set(DoubleSolenoid.Value.kOff);
  }
}
