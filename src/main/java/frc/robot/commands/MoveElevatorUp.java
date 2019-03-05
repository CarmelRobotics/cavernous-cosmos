package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;

public class MoveElevatorUp extends Command {

  private Elevator el;
  
  private double heightOfTarget;
  private double currentRelativePos;

  public MoveElevatorUp() {

    el = Robot.m_el;

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currentRelativePos = el.getElevatorActualEncoderPos() - el.getRelativeZero();
    System.out.println(currentRelativePos);
    double nearestHigherLevel = 0;
    for (int i = RobotMap.ELEV_INCHES.length - 1; convertInToRot(RobotMap.ELEV_INCHES[i]) > currentRelativePos; i--)
      nearestHigherLevel = convertInToRot(RobotMap.ELEV_INCHES[i]);
    heightOfTarget = nearestHigherLevel;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Command move = new MoveElevatorSetMotor(heightOfTarget - currentRelativePos);
    move.start();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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

  private double convertInToRot(double inches) {
    return inches*1; //insert conversion math here
  }
}