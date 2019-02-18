package frc.robot.commands;



import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

import frc.robot.RobotMap;

import frc.robot.subsystems.Elevator;



public class MoveElevatorSetMotor extends Command {



  private Elevator el;



  private double startingHeight;

  private int goal;

  private double heightOfTarget;

  private double totalMovement;

  private boolean isMovementPositive;



  public MoveElevatorSetMotor(double rotations) {



    el = Robot.m_el;

    totalMovement = rotations * 36;



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



    startingHeight = el.getElevatorActualEncoderPos() - el.getRelativeZero();

    heightOfTarget = startingHeight + totalMovement;

  }



  // Called repeatedly when this Command is scheduled to run

  @Override

  protected void execute() {

    double currentRelativePos = el.getElevatorActualEncoderPos() - el.getRelativeZero();

    double movementRemaining = heightOfTarget - currentRelativePos;



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

    el.setMotorSpeed(speed);

    System.out.println("Movement remaining: " + absRemain);

    System.out.println("Speed: " + speed);

    System.out.println("Total: " + absTotal);

  }



  // Make this return true when this Command no longer needs to run execute()

  @Override

  protected boolean isFinished() {

    if (Math.abs(el.getElevatorActualEncoderPos() - heightOfTarget) < 0.75)

      return true;

    return false;

  }



  // Called once after isFinished returns true

  @Override

  protected void end() {

    el.setMotorSpeed(0);

    System.out.println("done");

  }



  // Called when another command which requires one or more of the same

  // subsystems is scheduled to run

  @Override

  protected void interrupted() {

  }



  private double convertInToRot(double inches) {

    return inches*1; //insert conversion math here

  }

}