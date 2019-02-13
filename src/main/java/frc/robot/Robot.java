/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;



public class Robot extends TimedRobot {
  public static OI oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  //Subsystems
  private static DriveTrain drive; 
  private static CompressorA compress;

  //Controllers & Joysticks
  private static Joystick logiStickXtreme;


  @Override
  public void robotInit() {
    oi = new OI();
    
    SmartDashboard.putData("Auto mode", m_chooser);
  
    drive = new DriveTrain();
    compress = new CompressorA();

    logiStickXtreme = new Joystick(RobotMap.JOYSTICK_A_ID);
  }

  @Override
  public void robotPeriodic() {
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

 
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();


    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }


  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    //compress.start();
  }


  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    drive.robotDrive(logiStickXtreme.getX(), logiStickXtreme.getY(), logiStickXtreme.getZ());

  }


  @Override
  public void testPeriodic() {
  }
}
