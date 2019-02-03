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

  private static Joystick jStick_A;
  private static Joystick jStick_B;

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

  //Velocity used for rotation-based adjustments
  private double rotationVelocity; //slower than slow
  
  //counts how many times the robot has aligned itself
  private int adjustmentCounter;

  //number that adjustmentCounter needs to surpass before running perpendicularHeading()
  private int timesAdjustedBeforeUltrasound;

  private double stoppingDistanceToGoal;

  private double secondsWaitedBeforeBotRotates; //might be used in future if timer is used for the check before running perpendicularHeading()
  private boolean previouslyTurned;

  private boolean visionRunning;
  private Command visionCommand;

  private boolean userInput;
  private boolean stopCommand;

  public AutoLine() {

    irSys = Robot.m_ir;
    dTrain = Robot.m_dt;
    us = Robot.m_us;

    jStick_A = RobotMap.JOYSTICK_A;
    jStick_B = RobotMap.JOYSTICK_B;

    threshold = 0.0;

    slideVelocityFast = 0.0;
    slideVelocitySlow = 0.0;

    forwardVelocityFast = 0.0;
    forwardVelocitySlow = 0.0;

    rotationVelocity = 0.0;

    adjustmentCounter = 0;
    timesAdjustedBeforeUltrasound = 2;

    stoppingDistanceToGoal = 0.5;

    secondsWaitedBeforeBotRotates = 3.0;
    previouslyTurned = false;

    userInput = false;
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

    userInput = jStick_A.getX() != 0 || jStick_A.getY() != 0 || jStick_B.getX() != 0 || jStick_B.getY() != 0;
    
    //if user inputs a direction into the joystick, stop the command
    if (userInput) {
      stopCommand = true;
    }

    else if (!visionRunning && left && middle && right) {
      //if vision command isn't running and all three sensors are active
      dTrain.set4Wheel(forwardVelocitySlow, 0.0);

      if (previouslyTurned) {
        adjustmentCounter++;
        previouslyTurned = false;
      }

      if(adjustmentCounter > timesAdjustedBeforeUltrasound) { //if the robot has adjusted too many times with sliding, use rotation to straighten heading of robot
        perpendicularHeading();
        adjustmentCounter = 0;
      }

    }

    else if (!visionRunning && (left && (middle || right) || (middle && right))) {
      //if vision command isn't running and two of the sensors are active
      if (left && middle) { //slide left slowly
        dTrain.setSlide(slideVelocitySlow);
        previouslyTurned = true;
      }
      else if (left && right) {
        //this shouldn't happen
      }
      else if (middle && right) { //slide right slowly
        dTrain.setSlide(slideVelocitySlow);
        previouslyTurned = true;
      }
    }

    else if (!visionRunning && (left || middle || right)) {
      //if vision command isn't running and one sensor is active
      if (left) { //slide left quickly
        dTrain.setSlide(slideVelocityFast);
        previouslyTurned = true;
      }
      else if (middle) {
        if (previouslyTurned) {
          adjustmentCounter++;
          previouslyTurned = false;
        }

        if(adjustmentCounter > timesAdjustedBeforeUltrasound) { //if the robot has adjusted too many times with sliding, use rotation to straighten heading of robot
          perpendicularHeading();
          adjustmentCounter = 0;
        }
      }
      else if (right) { //slide right quickly
        dTrain.setSlide(slideVelocityFast);
        previouslyTurned = true;
      }
    }

    else if (!visionRunning) { //if vision command isn't running and no sensors are active, run vision
      visionRunning = true;
      visionCommand = new VisionFindGoal(this);
      visionCommand.start();
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

  /**
  * Uses ultrasonic sensor and robot rotations to determine whether the robot is facing
  * perpendicular to the wall in front of it and rotates itself so that the robot is facing
  * that wall if it initially isn't.
  */
  protected boolean perpendicularHeading() {
    Timer rotateTime = new Timer();
    double initialDistance = us.getDistance();
    double directionMultiplier;
    double previousDistance;
    boolean lineStillVisible;

    rotateTime.start();
    while (rotateTime.get() < 0.1)
      dTrain.set4Wheel(0.0, rotationVelocity);
    
    if (initialDistance < us.getDistance()) {
      directionMultiplier = -1.0;
    }
    else {
      directionMultiplier = 1.0;
    }

    do {
      userInput = jStick_A.getX() != 0 || jStick_A.getY() != 0 || jStick_B.getX() != 0 || jStick_B.getY() != 0;
      if (userInput) {
        stopCommand = true;
        return false;
      }

      previousDistance = us.getDistance();
      dTrain.set4Wheel(0.0, directionMultiplier * rotationVelocity);
      lineStillVisible = left || middle || right;
    } while (previousDistance > us.getDistance() || !lineStillVisible);
    /*
    rotateTime.reset();
    rotateTime.start();
    while (rotateTime.get() < 0.01)
      dTrain.set4Wheel(0.0, (directionMultiplier / -1.0) * rotationVelocity);
    */
    return true;
  }

  public void setVisionRunning (boolean v) {
    this.visionRunning = false;
  }
}