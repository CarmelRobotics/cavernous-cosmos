package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;

public class MoveDrivetrainZ extends Command {

  private DriveTrain drt;

  private double startLeft;
  private double goal;
  private double totalMovement;
  private double totalMovementHopefully;
  private int movementMultiplier;

  public MoveDrivetrainZ(double degrees) {

    double turningConversionFactor = 1;

    drt = Robot.drive;

    startLeft = drt.getEncoderFLeft();
    goal = startLeft + degrees * turningConversionFactor;

    totalMovement = startLeft + goal;

    if (degrees >= 0.0) {
      movementMultiplier = 1;
    }
    else {
      movementMultiplier = -1;
    }

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double currentLeft = drt.getEncoderFLeft();
    double distanceTraveled = currentLeft - startLeft;
    double distanceRemaining = totalMovement - distanceTraveled;

    double absRemain = Math.abs(distanceRemaining);
    double absTotal = Math.abs(totalMovement);

    double speed = 0.0;

    if (absRemain < 0.05 * absTotal) {
      speed = 0.12 * movementMultiplier;
    }
    else if (absRemain < 0.1 * absTotal) {
      speed = 0.20 * movementMultiplier;
    }
    else if (absRemain < 0.2 * absTotal) {
      speed = 0.25 * movementMultiplier;
    }
    else if (absRemain <= 0.3 * absTotal) {
      speed = 0.60 * movementMultiplier;
    }
    else if (absRemain <= 0.4 * absTotal) {
      speed = 0.75 * movementMultiplier;
    }
    else if (absRemain <= absTotal) {
      speed = 0.5 * movementMultiplier;
    }

    drt.set4Wheel(0.0, speed);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double traveledLeft = drt.getEncoderFLeft() - startLeft;
    double remainingLeft = totalMovement - traveledLeft;
    double absLeft = Math.abs(remainingLeft);

    if (absLeft < 5)
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