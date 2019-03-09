/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.subsystems.BallIntake;
import frc.robot.RobotMap;

public class IntakeIn extends Command {

  private BallIntake bi;

  public IntakeIn() {
    requires(bi);
    bi = new BallIntake();
    ls = new DigitalInput(RobotMap.INTAKE_LIMIT_ID);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    bi.intakeIn();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !ls.get();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    bi.intakeOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
