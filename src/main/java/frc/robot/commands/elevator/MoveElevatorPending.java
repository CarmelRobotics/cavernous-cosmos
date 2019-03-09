package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;

public class MoveElevatorPending extends Command {

  private int initialButton;
  private int secondButton;
  Command move;
  private Elevator el;

 /**
 * initialButton
 * 0: low elevator button pressed
 * 1: middle elevator button pressed
 * 2: high elevator button pressed
 *
 * secondButton
 * 0: panel elevator button pressed
 * 1: fuel elevator button pressed
 */
  public MoveElevatorPending(int panelOrFuel) {
    el = Robot.m_el;
    initialButton = el.getDesiredLevel();
    secondButton = panelOrFuel;
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

  if (secondButton == 0) {
    if (initialButton == 0) {
      move = new MoveElevatorPos(RobotMap.ELEV_LO_PANEL);
      move.start();
    }
    else if (initialButton == 1) {
      move = new MoveElevatorPos(RobotMap.ELEV_MI_PANEL);
      move.start();
    }
    else if (initialButton == 2) {
      move = new MoveElevatorPos(RobotMap.ELEV_HI_PANEL);
      move.start();
    }
  }
  else if (secondButton == 1) {
    if (initialButton == 0) {
      move = new MoveElevatorPos(RobotMap.ELEV_LO_FUEL);
      move.start();
    }
    else if (initialButton == 1) {
      move = new MoveElevatorPos(RobotMap.ELEV_MI_FUEL);
      move.start();
    }
    else if (initialButton == 2) {
      move = new MoveElevatorPos(RobotMap.ELEV_HI_FUEL);
      move.start();
    }
  }

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
}