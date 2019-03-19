/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.vacuum;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Vacuum;


public class SuckerIn extends Command {
  private static Vacuum vac;
  public SuckerIn() {
  
    vac = Robot.vac;
    requires(vac);

  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  
     // if(vac.isSuckerDown) {
    vac.suckerIn();
     // }
      
    //else {
    //  vac.suckerDown();
    //}
    //System.out.println("Sucker up");
    
    
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
  // Called once after isFinished returns true
  @Override
  protected void end() {
    vac.servoLeft.stopMotor();
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    vac.servoLeft.stopMotor();
  }
}
