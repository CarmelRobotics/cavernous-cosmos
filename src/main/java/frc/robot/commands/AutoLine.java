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
  private double left;
  private double middle;
  private double right;

  private double threshold; 

  private boolean visionRunning;
  private Command visionCommand;
  
  public AutoLine() {

    irSys = Robot.m_ir;

    threshold = 0.0;

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

    if (!visionRunning && (isLine(left) && isLine(middle) && isLine(right))) { 
      //if vision command isn't running and all three sensors are active

    }

    else if (!visionRunning && (isLine(left) && (isLine(middle) || isLine(right)) || (isLine(middle) && isLine(right)))) { 
      //if vision command isn't running and two of the sensors are active

    }

    else if (!visionRunning && (isLine(left) || isLine(middle) || isLine(right))) { 
      //if vision command isn't running and one sensor is active

    }
    else if (!visionRunning) { //if none are active
      visionRunning = true;
      visionCommand = new VisionFindGoal();
      visionCommand.start();
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

  protected boolean isLine(double voltage) {
    if (voltage > threshold)
      return true;
    return false;
  }

  
}