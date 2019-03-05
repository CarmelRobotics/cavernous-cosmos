/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;

import frc.robot.commands.*;
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
    private static Button jst_button_elevup;
    private static Button jst_button_elevdown;
    private static Button gearshift;
    private static Button gearshiftDown;
    public static Button changeArmAngleTo0;
    public static Button changeArmAngleTo1;
    public static Button changeArmAngleTo2;
  
  /*Joysticks */
    private static Joystick jStick_A;
    private static Joystick jStick_B;
 
  
  public static void initialize() {
    /* Joystick inits */
      jStick_A = RobotMap.JOYSTICK_A;
      jStick_B = RobotMap.JOYSTICK_B;

    /* Button inits */
      /* Middle Wheel */
        wheelUp = RobotMap.WHEEL_UP;
        wheelDown = RobotMap.WHEEL_DOWN;
        suckerControl = RobotMap.SUCC_CONTROL;
     
      /* Lifterarm */
        changeArmAngleTo0 = RobotMap.CHANGE_ARM_ANGLE_0;
        changeArmAngleTo1 = RobotMap.CHANGE_ARM_ANGLE_1;
        changeArmAngleTo2 = RobotMap.CHANGE_ARM_ANGLE_2;

      /* Elevator */
        jst_button_elevup = RobotMap.ELEV_UP_BUTTON;
        jst_button_elevdown = RobotMap.ELEV_DOWN_BUTTON;
        
        gearshift = RobotMap.GEARSHIFT;

      /* Buttons */
        wheelUp.whenPressed(new WheelUp());
        wheelDown.whenPressed(new WheelDown());
      
        SuckerControl.whenPressed(new SuckerControl());
      
      /* DriveTrain */
        gearshift.whenPressed(new Gearshift());
      
      /* LifterArm */
        changeArmAngleTo0.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_0));
        changeArmAngleTo1.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_1));
        changeArmAngleTo2.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_2));

      /* Elevator Commands */
        jst_button_elevup.whileHeld(new MoveElevatorManual(1));
        jst_button_elevdown.whileHeld(new MoveElevatorManual(-1));
  }
}
