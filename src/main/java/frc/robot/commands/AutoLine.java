/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IRSystem;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoLine extends Command {
  
  private final IRSystem irSys;
  private final DriveTrain dTrain;
  private boolean left;
  private boolean middle;
  private boolean right;

  private double threshold;
  private double slideVelocity;

  private boolean visionRunning;
  private Command visionCommand;
  
  public AutoLine() {

    irSys = Robot.m_ir;
    dTrain = Robot.m_dt;

    threshold = 0.0;
    slideVelocity = 0.0;

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

    left = isLine(irSys.getLeftIR());
    middle = isLine(irSys.getMiddleIR());
    right = isLine(irSys.getRightIR());
    

    if (!visionRunning && left && middle && right) {
      //if vision command isn't running and all three sensors are active
      dTrain.setSlide(slideVelocity);
    }

    else if (!visionRunning && (left && (middle || right) || (middle && right))) {
      //if vision command isn't running and two of the sensors are active
      if (left && middle) {

      }
      else if (left && right) {

      }
      else if (middle && right) {
        
      }
    }

    else if (!visionRunning && (left || middle || right)) {
      //if vision command isn't running and one sensor is active
      if (left) {

      }
      else if (middle) {

      }
      else if (right) {

      }
    }

    else if (!visionRunning) {
      //if vision command isn't running and no sensors are active
      visionRunning = true;
      visionCommand = new VisionFindGoal();
      visionCommand.start();
    }

    else {
      //if vision is running

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