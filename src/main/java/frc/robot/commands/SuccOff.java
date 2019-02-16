
package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Vacuum;
import edu.wpi.first.wpilibj.command.Command;

public class SuccOff extends Command {
  private static Vacuum vac;
  public static OI oi;


  public SuccOff() {
    vac = new Vacuum();


    requires(vac);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      vac.initialize();
  }
  

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    vac.off();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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

