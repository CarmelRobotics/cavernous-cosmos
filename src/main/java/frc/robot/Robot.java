/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.commands.drivetrain.MoveDrivetrainZ;
import frc.robot.subsystems.*;
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
  public static DriveTrain drive;
  public static IRSystem m_ir;
  public static Ultrasound m_us;
  public static Elevator elevator;
  public static Vacuum vac;
  public static WheelDropper dropper;
  public static Compressor compressor;
  public static LifterArm arm;
  public static Vision vision;
  public static BallIntake intake;

//Changes
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
 

  @Override
  public void robotInit() {

	  oi = new OI();

    SmartDashboard.putData("Auto mode", m_chooser);
    drive = new DriveTrain();
    elevator = new Elevator();
    vac = new Vacuum();
    dropper = new WheelDropper();
    compressor = new Compressor();
    arm = new LifterArm();
    vision = new Vision();
    intake = new BallIntake();

    OI.initialize(); //Calls the init method from the OI class
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

    

	  compressor.start();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    //Command big = new MoveDrivetrainZ(90);
   // big.start();
  }

  @Override
  public void teleopPeriodic() {
    //System.out.println(m_ir.getLeftIR());
  
    Scheduler.getInstance().run();
    //m_el.testMotor(0.1);
  //  System.out.println("Elevator encoder value: " + m_el.getElevatorActualEncoderPos());
    drive.slideDrive();


  }

  @Override
  public void testPeriodic() {
  }
	/**
	 * This function is called periodically during test mode.
	 */

}