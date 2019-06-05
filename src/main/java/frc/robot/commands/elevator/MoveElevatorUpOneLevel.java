package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;

public class MoveElevatorUpOneLevel extends Command {

  private Elevator el;
  private Command move;
  private double heightOfTarget;
  private double currentRelativePos;

  public MoveElevatorUpOneLevel() {

    el = Robot.elevator;

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currentRelativePos = el.getElevatorActualEncoderPos() - el.getRelativeZero();

    System.out.println(currentRelativePos);
    double nearestHigherLevel = 0;

    for (int i = RobotMap.ELEV_INCHES.length - 1; el.convertInToRot(RobotMap.ELEV_INCHES[i]) > currentRelativePos; i--)
      nearestHigherLevel = el.convertInToRot(RobotMap.ELEV_INCHES[i]);

    heightOfTarget = nearestHigherLevel;

    //move = new MoveElevatorRotations(heightOfTarget - currentRelativePos);
    //move.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    move.close();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    move.close();
  }

}