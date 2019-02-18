/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Keep all potentiometers on the IR sensors to the very right
 */
public class IRSystem extends Subsystem {

  private AnalogInput leftIR;
  private AnalogInput middleIR;
  private AnalogInput rightIR;
  
  public IRSystem() {
		leftIR = new AnalogInput(RobotMap.LEFT_IR);
    middleIR = new AnalogInput(RobotMap.MIDDLE_IR);
    rightIR = new AnalogInput(RobotMap.RIGHT_IR);
  }
  
  /**
   * @return the leftIR state
   */
  public double getLeftIR() {
    return leftIR.getAverageVoltage();
  }

  /**
   * @return the middleIR state
   */
  public double getMiddleIR() {
    return middleIR.getAverageVoltage();
  }

  /**
   * @return the rightIR state
   */
  public double getRightIR() {
    return rightIR.getAverageVoltage();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
