/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;



public class DriveTrain extends Subsystem {
  private static CANSparkMax brSpark;
  private static CANSparkMax blSpark;
  private static CANSparkMax frSpark;
  private static CANSparkMax flSpark;

  private static SpeedControllerGroup sparkGroupLeft;
  private static SpeedControllerGroup sparkGroupRight;

  private static DifferentialDrive drive;

  private static Joystick jstick;

  public DriveTrain(){
    super("Drive Train");
    brSpark = new CANSparkMax(RobotMap.CAN_ID_BACK_RIGHT, MotorType.kBrushless);
    blSpark = new CANSparkMax(RobotMap.CAN_ID_BACK_LEFT, MotorType.kBrushless);
    frSpark = new CANSparkMax(RobotMap.CAN_ID_FRONT_RIGHT, MotorType.kBrushless);
    flSpark = new CANSparkMax(RobotMap.CAN_ID_BACK_LEFT, MotorType.kBrushless);

    sparkGroupLeft = new SpeedControllerGroup(blSpark, flSpark);
    sparkGroupRight = new SpeedControllerGroup(brSpark, frSpark);

    drive = new DifferentialDrive(sparkGroupLeft, sparkGroupRight);


    jstick = RobotMap.JOYSTICK_A;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void robotDrive(){
    drive.arcadeDrive(jstick.getX(), jstick.getY());
  }
}
