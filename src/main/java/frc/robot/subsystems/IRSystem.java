/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IRSystem extends Subsystem {

  public DigitalInput leftIR;
  public DigitalInput middleIR;
  public DigitalInput rightIR;
  
  public IRSystem() {
		leftIR = new DigitalInput(RobotMap.LEFT_IR);
    middleIR = new DigitalInput(RobotMap.MIDDLE_IR);
    rightIR = new DigitalInput(RobotMap.RIGHT_IR);
  }
  
  /**
   * @return the leftIR state
   */
  public boolean getLeftIR() {
    return leftIR.get();
  }

  /**
   * @return the middleIR state
   */
  public boolean getMiddleIR() {
    return middleIR.get();
  }

  /**
   * @return the rightIR state
   */
  public boolean getRightIR() {
    return rightIR.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
