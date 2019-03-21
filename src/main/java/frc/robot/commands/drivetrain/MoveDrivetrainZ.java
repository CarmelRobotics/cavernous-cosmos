package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;

public class MoveDrivetrainZ extends Command {

  private DriveTrain drt;

  private double startL;
  private double startR;
  private int goal;
  private double targetGoal;
  private double totalMovement;
  private double totalMovementHopefully;
  private boolean isMovementPositive;

  public MoveDrivetrainZ(double degrees) {

    drt = Robot.drive;

    //accounting for gear ratio
    totalMovement = degrees;//((degrees/360)*34.648*Math.PI)/(6*Math.PI);

    totalMovementHopefully = totalMovement/2;

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
    startL = drt.getEncoderFLeft();
    startR = drt.getEncoderFRight();
    //drt.set4Wheel(0.0, 0.5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //current is derived the same way as start but is called every time execute() runs
    double currentPos = drt.getEncoderFLeft();
    double distanceTraveled = currentPos - startL;
    double movementRemaining = totalMovementHopefully - distanceTraveled;

    double negativeMovementMultiplier;
    if (isMovementPositive)
      negativeMovementMultiplier = 1.0;
    else
      negativeMovementMultiplier = -1.0;
    double speed = 0;

    double absRemain = Math.abs(movementRemaining);
    double absTotal = Math.abs(totalMovement);
    /**
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
    */
    if (absRemain <= absTotal) {
      speed = 0.5 * negativeMovementMultiplier;
    }
    drt.set4Wheel(0.0, 0.5);
    System.out.println("Movement remaining: " + absRemain);
    System.out.println("Speed: " + speed);
    System.out.println("Total: " + absTotal);
    System.out.println("Current encoder: " + drt.getEncoderFLeft());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double traveledL = drt.getEncoderFLeft() - startL;
    double remainingL = totalMovementHopefully - traveledL;
    double absL = Math.abs(remainingL);

    double traveledR = drt.getEncoderFLeft() - startL;
    double remainingR = totalMovementHopefully - traveledR;
    double absR = Math.abs(remainingR);

    //if (absL < 5 && absR < 5)
      //return true;
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