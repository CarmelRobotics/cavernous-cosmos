package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;

public class MoveElevatorRotations extends Command {

  private Elevator el;

  private double startingHeight;
  private int goal;
  private double heightOfTarget;
  private double totalMovement;
  private boolean isMovementPositive;
  double movementRemaining;
  double currentRelativePos;

  public MoveElevatorRotations(int goal) {
    
    el = Robot.elevator;
    int g = goal;

    heightOfTarget = RobotMap.ELEV_INCHES[g] / 12 * 36 * -1;
    double currentRelativePos = (el.getElevatorActualEncoderPos() - el.getRelativeZero())/12 * 36 * -1;
    totalMovement = (heightOfTarget - currentRelativePos);

    movementRemaining = totalMovement;

    System.out.println("total " + totalMovement);
    System.out.println("height " + heightOfTarget);
    System.out.println("current " + currentRelativePos);

    //accounting for gear ratio

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
      //heightOfTarget = el.convertInToRot(RobotMap.ELEV_INCHES[goal]);
      //double currentRelativePos = (el.getElevatorActualEncoderPos() - el.getRelativeZero());
      //totalMovement = heightOfTarget - currentRelativePos;

    //starting height is the current encoder value minus the encoder value read as zero at the beginning of operation; current relative value
    //startingHeight = (el.getElevatorActualEncoderPos() - el.getRelativeZero());
    //heightOfTarget = startingHeight + totalMovement;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("print line");
    //current height is derived the same way as starting height but is called every time execute() runs
    currentRelativePos = (el.getElevatorActualEncoderPos() - el.getRelativeZero());

    double negativeMovementMultiplier;
    if (isMovementPositive)
      negativeMovementMultiplier = 1.0;
    else
      negativeMovementMultiplier = -1.0;
    double speed = 0;

    double absRemain = Math.abs(movementRemaining);
    double absTotal = Math.abs(totalMovement);

    /*
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
    if (absRemain <= 0.2 * absTotal) {
      speed = 0.55 * negativeMovementMultiplier;
    } */
    if (absRemain <= absTotal) {
      speed = 0.65 * negativeMovementMultiplier;
    }
    movementRemaining = (heightOfTarget - currentRelativePos);
    el.setMotorSpeed(speed);
    /**
    System.out.println("Movement remaining: " + absRemain);
    System.out.println("Speed: " + speed);
    System.out.println("Total: " + absTotal);
    System.out.println("Current: " + currentRelativePos);
    */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double absRemain = Math.abs(movementRemaining);
    double absTotal = Math.abs(totalMovement);
    
    if (Math.abs(movementRemaining) < 3 || absRemain > absTotal)
      return true;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    el.setMotorSpeed(0);
    System.out.println("done");
    RobotMap.ELEV_MOVING = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

}