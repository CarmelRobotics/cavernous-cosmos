/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */

/* Open Source Software - may be modified and shared by FRC teams. The code   */

/* must be accompanied by the FIRST BSD license file in the root directory of */

/* the project.                                                               */

/*----------------------------------------------------------------------------*/



package frc.robot;



import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ResetElevator;
import frc.robot.subsystems.CompressorA;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.IRSystem;
import frc.robot.subsystems.LifterArm;
import frc.robot.subsystems.SimpleElevator;
import frc.robot.subsystems.Vacuum;
import frc.robot.subsystems.Ultrasound;
import frc.robot.subsystems.WheelDropper;
import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.DigitalInput;




public class Robot extends TimedRobot {
  public static OI oi;
  public static DriveTrain driver;
  public static IRSystem m_ir;
  public static Ultrasound m_us;
  public static Elevator m_el;
  public static Vacuum vac;
  public static WheelDropper dropper;
  public static CompressorA compressor;
  public static LifterArm arm;

//Changes
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  private static DriveTrain drive;
public static DriveTrain m_dt; 


  @Override
  public void robotInit() {
  
    m_ir = new IRSystem();
	driver = new DriveTrain();
  //  m_us = new Ultrasound();
   // m_el = new Elevator();
	oi = new OI();
    
    SmartDashboard.putData("Auto mode", m_chooser);
    drive = new DriveTrain();
  //  vac = new Vacuum();
    dropper = new WheelDropper();
    compressor = new CompressorA(); 
   
    //arm = new LifterArm();
    OI.initialize();

  }

  @Override
  public void robotPeriodic() {
  }


  @Override
  public void disabledInit() {
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
   // Command reset = new ResetElevator();
	//reset.start();
	compressor.start();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }


  @Override
  public void teleopPeriodic() {
    //System.out.println(m_ir.getLeftIR());
  //  compressor.checkPressure();
    Scheduler.getInstance().run();
    //m_el.testMotor(0.1);
  //  System.out.println("Elevator encoder value: " + m_el.getElevatorActualEncoderPos());
    drive.slideDrive();
    drive.motorTest();
   System.out.println("Left: "+  m_ir.getLeftIR());
   System.out.println("Middle:" +  m_ir.getMiddleIR());
   System.out.println("right" +  m_ir.getRightIR());
  }


  @Override
  public void testPeriodic() {
  }

	/**

	 * This function is called periodically during test mode.

	 */


	public static DriveTrain getDriveTrain() { //method to return the drive train as a drive train.

		return driver;

	}

	
	


}