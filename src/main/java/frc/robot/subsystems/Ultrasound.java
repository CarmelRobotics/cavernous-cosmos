/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * Ultrasonic sensor to sense obstacles in front of the robot
 */
public class Ultrasound extends Subsystem {

  private Ultrasonic us;

  public Ultrasound() {
    us = new Ultrasonic(RobotMap.ULTRASOUND_OUT, RobotMap.ULTRASOUND_IN);
    us.setAutomaticMode(true);
  }

  /**
   * @return the distance to approaching object
   */
  public double getDistance() {
    return us.getRangeInches();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
