/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.IRSystem;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoLine extends Command {
  
  private final IRSystem irSys;
  private boolean left;
  private boolean middle;
  private boolean right; 
  
  public AutoLine() {

    irSys = Robot.m_ir;

    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_ir);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    left = irSys.getLeftIR();
    middle = irSys.getMiddleIR();
    right = irSys.getRightIR();

    if (left && middle && right) { //if all three sensors are active

    }
    else if (left && (middle || right) || (middle && right)) { //if two of the sensors are active

    }
    else if (left || middle || right) { //if one is active

    }
    else { //if none are active

    }


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
