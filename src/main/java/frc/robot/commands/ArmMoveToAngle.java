/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.LifterArm;

public class ArmMoveToAngle extends Command {

  private LifterArm arm;

  public ArmMoveToAngle() {

    arm = Robot.arm;
    
		requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Starting pos
    arm.atBottom = false;
    arm.atAngle = false;
    arm.atTop= true;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(arm.getTopSwitch() == true) {
    arm.moveMotorForward();
    }

    else {
      arm.moveMotorReverse();
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return arm.getAngleSwitch();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    arm.armStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
