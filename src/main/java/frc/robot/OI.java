/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;

import frc.robot.commands.*;
import frc.robot.commands.arm.ArmChangePosition;
import frc.robot.commands.arm.ArmManualLower;
import frc.robot.commands.arm.ArmManualRaise;
import frc.robot.commands.drivetrain.Gearshift;
import frc.robot.commands.drivetrain.WheelDown;
import frc.robot.commands.drivetrain.WheelUp;
import frc.robot.commands.elevator.MoveElevatorManual;
import frc.robot.commands.intake.IntakeIn;
import frc.robot.commands.intake.IntakeOut;
import frc.robot.commands.vacuum.SuckerControl;
import frc.robot.commands.vacuum.SuckerDown;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {

  /* Joystick Button Declaration */
    private static Button wheelUp;
    private static Button wheelDown;
    private static Button lifterArmDown;
    private static Button lifterArmUp;
    private static Button suckerControl;
    private static Button suckerDown;
    private static Button jst_button_elevup;
    private static Button jst_button_elevdown;
    private static Button jst_button_elevhatch2;
    private static Button gearshift;
    public static Button changeArmAngleTo0;
    public static Button changeArmAngleTo1;
    public static Button changeArmAngleTo2;
    private static Button intakeSpit;
    private static Button intakeSuck;

  

  /*Joysticks */
    private static Joystick jStick_A;
    private static Joystick jStick_B;


  public static void initialize() {
    /* Joystick inits */
      jStick_A = RobotMap.JOYSTICK_A;
      jStick_B = RobotMap.GUITAR;

      

    /* Button inits */
      //Middle Wheel
        wheelUp = RobotMap.WHEEL_UP;
        wheelDown = RobotMap.WHEEL_DOWN;
        suckerControl = RobotMap.SUCC_CONTROL;
        suckerDown = RobotMap.SUCC_DOWN;
      // Lifterarm
        changeArmAngleTo0 = RobotMap.CHANGE_ARM_ANGLE_0;
        changeArmAngleTo1 = RobotMap.CHANGE_ARM_ANGLE_1;
        changeArmAngleTo2 = RobotMap.CHANGE_ARM_ANGLE_2;

        lifterArmUp = RobotMap.MANUAL_LIFTERARM_UP_BUTTON;
        lifterArmDown= RobotMap.MANUAL_LIFTERARM_DOWN_BUTTON;
      // Elevator
        jst_button_elevup = RobotMap.ELEV_UP_BUTTON;
        jst_button_elevdown = RobotMap.ELEV_DOWN_BUTTON;
        jst_button_elevhatch2 = RobotMap.ELEV_HATCH_2_BUTTON;
        gearshift = RobotMap.GEARSHIFT;

        //Intake Init
       intakeSuck = RobotMap.INTAKEIN_BUTTON;
        intakeSpit = RobotMap.INTAKEOUT_BUTTON;
      
      // Buttons
        //Solenoids MUST be while held. One signal does seem to be enough...
        wheelUp.whileHeld(new WheelUp());
        wheelDown.whileHeld(new WheelDown());

        suckerControl.whenPressed(new SuckerControl());
        suckerDown.whenPressed(new SuckerDown());
      // DriveTrain
        gearshift.whileHeld(new Gearshift());

      // LifterArm
        changeArmAngleTo0.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_0));
        changeArmAngleTo1.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_1));
        changeArmAngleTo2.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_2));
        lifterArmUp.whileHeld(new ArmManualRaise());
        lifterArmDown.whileHeld(new ArmManualLower());
      // Elevator Commands
        jst_button_elevup.whileHeld(new MoveElevatorManual(1.0));
        jst_button_elevdown.whileHeld(new MoveElevatorManual(-1.0));
        //jst_button_elevhatch2.whileHeld(new MoveElevatorPending(-1.0));

      // Intake Commands
        intakeSuck.whileHeld(new IntakeIn());
        intakeSpit.whileHeld(new IntakeOut());
  }
}
