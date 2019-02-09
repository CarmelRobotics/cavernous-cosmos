/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ResetElevator;
import frc.robot.subsystems.*;



public class Robot extends TimedRobot {
  public static OI m_oi;
  public static IRSystem m_ir;
  public static DriveTrain m_dt;
  public static Ultrasound m_us;
  public static Elevator m_el;
  //public static Vacuum vac;
  public static WheelDropper dropper;
  public static CompressorA compressor;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  private static DriveTrain drive; 


  @Override
  public void robotInit() {
    m_oi = new OI();
    m_ir = new IRSystem();
    m_dt = new DriveTrain();
    m_us = new Ultrasound();
    m_el = new Elevator();

    
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  
    drive = new DriveTrain();
    //vac = new Vacuum();
    dropper = new WheelDropper();
    compressor = new CompressorA();
    OI.initialize();

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
    Command reset = new ResetElevator();
    reset.start();
    //m_el.setElevatorMovement(10);

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }


  @Override
  public void teleopPeriodic() {
    //System.out.println(m_ir.getLeftIR());
    Scheduler.getInstance().run();
    //m_el.testMotor(0.1);
    System.out.println("Elevator encoder value: " + m_el.getElevatorActualEncoderPos());
    //drive.slideDrive();

  }


  @Override
  public void testPeriodic() {
  }
}
