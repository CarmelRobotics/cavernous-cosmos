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
import frc.robot.commands.arm.PistonRegulator;
import frc.robot.commands.elevator.MoveElevatorPos;
import frc.robot.commands.elevator.MoveElevatorRotations;
import frc.robot.commands.elevator.MoveElevatorUpOneLevel;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Watchdog;


public class Robot extends TimedRobot {
  //Rory was here
  public static OI oi;
  public static DriveTrain drive;
  public static IRSystem m_ir;
  public static Ultrasound m_us;
  public static Elevator elevator;
  public static Vacuum vac;
  //public static WheelDropper dropper;
  public static Compressor compressor;
  public static LifterArm arm;
  public static Vision vision;
  public static BallIntake intake;
  public static HatchPiston piston;
  private Command autoPiston;
  private Command telePiston;
  private static final boolean USE_PI_VISION = false;
  //public static Watchdog wd;

//Changes
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
 

  @Override
  public void robotInit() {

    oi = new OI();
    
    //wd = Watchdog.getInstance();

    SmartDashboard.putData("Auto mode", m_chooser);
    drive = new DriveTrain();
    elevator = new Elevator();
    vac = new Vacuum();
    //dropper = new WheelDropper();
    compressor = new Compressor();
    arm = new LifterArm();
    intake = new BallIntake();
    piston = new HatchPiston();
    if(USE_PI_VISION){
      vision = new Vision();
    }else{
      VideoSource camera = CameraServer.getInstance().startAutomaticCapture();
    }
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
    pistonRegulator();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    drive.slideDrive();
    pistonRegulator();
  }
  @Override
  public void teleopInit() {
    

   //Command test = new MoveElevatorPos(1);
   //test.start();
    //Need to test this.
    double actualPosition = elevator.getElevatorActualEncoderPos();
    elevator.setRelativeZero(actualPosition);
  
	compressor.start();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

   // Command big = new MoveDrivetrainZ(90);
   // big.start();
  // 
  }

  @Override
  public void teleopPeriodic() {
    
    
    pistonRegulator();
    Scheduler.getInstance().run();
    //m_el.testMotor(0.1);
  //  System.out.println("Elevator encoder value: " + m_el.getElevatorActualEncoderPos());
    drive.slideDrive();
    if(USE_PI_VISION)
      vision.VisionPeriodic();
    //System.out.println(RobotMap.PISTON_OUT);
    System.out.println("Stop: " + intake.getStopLimit());
  }

  @Override
  public void testPeriodic() {
  }
	/**
	 * This function is called periodically during test mode.
	 */

  private void pistonRegulator() {
    if (RobotMap.PISTON_OUT) {
      piston.out();
    }
    else if (!RobotMap.PISTON_OUT) {
      piston.in();
    }
  }

}