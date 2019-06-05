/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.vacuum.SuckerIn;
import frc.robot.subsystems.HatchPiston;

public class PistonIn extends Command {
  private HatchPiston hPiston;
  private Command vac;

  public PistonIn() {
    hPiston = Robot.piston;

    requires(hPiston);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    RobotMap.PISTON_OUT = false;
    //hPiston.in();
    //System.out.println("Piston In");
   
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //hPiston.stop();
    //vac.close();
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    hPiston.stop();
    vac.close();
  }
}
