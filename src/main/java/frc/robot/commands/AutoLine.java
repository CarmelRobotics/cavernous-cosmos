/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IRSystem;
import frc.robot.subsystems.Ultrasound;

/**
 * Aligns robot to guideline and moves it forward until it reaches a wall.
 * Runs vision if a guideline isn't found by the IR sensors.
 */
public class AutoLine extends Command {

  private final IRSystem irSys;
  private final DriveTrain dTrain;
  private final Ultrasound us;

  private boolean left;
  private boolean middle;
  private boolean right;

  //The level of voltage received which, past that value, will indicate a line's presence beneath an IR sensor
  private double threshold;

  //Velocities used for the fifth wheel's adjustments
  private double slideVelocityFast;
  private double slideVelocitySlow;

  //Velocities used for forward movement along a line
  private double forwardVelocityFast;
  private double forwardVelocitySlow;

  private double stoppingDistanceToGoal;

  private boolean visionRunning;
  private Command visionCommand;

  private boolean stopCommand;

  public AutoLine() {

    irSys = Robot.m_ir;
    dTrain = Robot.m_dt;
    us = Robot.m_us;

    threshold = 0.0;

    slideVelocityFast = 0.0;
    slideVelocitySlow = 0.0;

    forwardVelocityFast = 0.0;
    forwardVelocitySlow = 0.0;

    stoppingDistanceToGoal = 0.5; //inches

    stopCommand = false;

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
    
    //gets status of IR sensors
    left = isLine(irSys.getLeftIR());
    middle = isLine(irSys.getMiddleIR());
    right = isLine(irSys.getRightIR());

    if (!visionRunning) {
      if (middle) {
        //if vision command isn't running and two of the sensors are active
        if (left) { //slide left slowly
          dTrain.set4Wheel(0.0, 0.0);
          dTrain.setSlide(slideVelocitySlow);
        }
        else if (right) { //slide right slowly
          dTrain.set4Wheel(0.0, 0.0);
          dTrain.setSlide(slideVelocitySlow);
        }
        else {
          dTrain.setSlide(0.0);
          dTrain.set4Wheel(forwardVelocitySlow, 0.0);
        }
      }
      else if (left) { //slide left quickly
        dTrain.set4Wheel(0.0, 0.0);
        dTrain.setSlide(slideVelocityFast);
      }
      else if (right) { //slide right quickly
        dTrain.set4Wheel(0.0, 0.0);
        dTrain.setSlide(slideVelocityFast);
      }
      else { //if vision command isn't running and no sensors are active, run vision
        visionRunning = true;
        visionCommand = new VisionFindGoal(this);
        visionCommand.start();
      }
    }
    else {
      //if vision command is running
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (us.getDistance() <= stoppingDistanceToGoal)
      stopCommand = true;
    return stopCommand;
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

  /**
   * Determines if an IR sensor is reading a line based on the voltage threshold value.
   */
  protected boolean isLine(double voltage) {
    if (voltage > threshold)
      return true;
    return false;
  }

  public void setVisionRunning (boolean v) {
    this.visionRunning = false;
  }
}