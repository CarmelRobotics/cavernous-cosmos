/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

public class MoveElevatorChangeLevelVariable extends Command {

  private int level;
  private Elevator el;

 /**
 * levels
 * 0: low elevator button pressed
 * 1: middle elevator button pressed
 * 2: high elevator button pressed
 */
  public MoveElevatorChangeLevelVariable(int desiredLevel) {
    
    level = desiredLevel;

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    el = Robot.m_el;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    el.setDesiredLevel(level);;

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}