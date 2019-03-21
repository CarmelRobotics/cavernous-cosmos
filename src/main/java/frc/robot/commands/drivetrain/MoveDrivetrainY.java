package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;

public class MoveDrivetrainY extends Command {

  private DriveTrain drt;

  private double start;
  private int goal;
  private double targetGoal;
  private double totalMovement;
  private boolean isMovementPositive;

  public MoveDrivetrainY(double rotations) {

    drt = Robot.drive;

    //accounting for gear ratio
    totalMovement = rotations;

    //variable to easily check if movement is up or down
    if (totalMovement >= 0)
      isMovementPositive = true;
    else
      isMovementPositive = false;

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    start = drt.getEncoderFLeft();
    targetGoal = start + totalMovement;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //current is derived the same way as start but is called every time execute() runs
    double currentPos = drt.getEncoderFLeft();
    double movementRemaining = targetGoal - currentPos;

    double negativeMovementMultiplier;
    if (isMovementPositive)
      negativeMovementMultiplier = 1.0;
    else
      negativeMovementMultiplier = -1.0;
    double speed = 0;

    double absRemain = Math.abs(movementRemaining);
    double absTotal = Math.abs(totalMovement);

    if (absRemain < 0.05 * absTotal) {
      speed = 0.12 * negativeMovementMultiplier;
    }
    else if (absRemain < 0.1 * absTotal) {
      speed = 0.20 * negativeMovementMultiplier;
    }
    else if (absRemain < 0.2 * absTotal) {
      speed = 0.25 * negativeMovementMultiplier;
    }
    else if (absRemain <= 0.3 * absTotal) {
      speed = 0.60 * negativeMovementMultiplier;
    }
    else if (absRemain <= 0.4 * absTotal) {
      speed = 0.75 * negativeMovementMultiplier;
    }
    else if (absRemain <= absTotal) {
      speed = 0.85 * negativeMovementMultiplier;
    }
    drt.set4Wheel(speed, 0.0);
    System.out.println("Movement remaining: " + absRemain);
    System.out.println("Speed: " + speed);
    System.out.println("Total: " + absTotal);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Math.abs(drt.getEncoderFLeft() - targetGoal) < 0.75)
      return true;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //drt.set4Wheel(0.0, 0.0);
    System.out.println("done");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

}