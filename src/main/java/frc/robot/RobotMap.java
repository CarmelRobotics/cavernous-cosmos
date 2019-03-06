/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  /* Other Public Variables */
    public static boolean WHEEL_DROPPED = false;

  /* Joystick Button IDs*/
    public static final int BUTTON_ID_WHEEL_UP = 0;
    public static final int BUTTON_ID_WHEEL_DOWN = 0;
    public static final int BUTTON_ID_GEARSHIFT = 0;

    public static final int BUTTON_ID_SUCC_CONTROL = 0;
    public static final int BUTTON_ID_SUCC_UP = 0;
    public static final int BUTTON_ID_SUCC_DOWN = 0;

    public static final int BUTTON_ID_CHANGE_ARM_ANGLE_0 = 0;
    public static final int BUTTON_ID_CHANGE_ARM_ANGLE_1 = 0;
    public static final int BUTTON_ID_CHANGE_ARM_ANGLE_2 = 0;

    public static final int BUTTON_ID_ELEV_UP_BUTTON = 0;
    public static final int BUTTON_ID_ELEV_DOWN_BUTTON = 0;

  /* Spark CAN IDs */
    public static final int CAN_ID_FRONT_RIGHT = 3;
    public static final int CAN_ID_BACK_RIGHT = 1;
    public static final int CAN_ID_FRONT_LEFT = 4;
    public static final int CAN_ID_BACK_LEFT = 2;
    public static final int CAN_ID_DROPWHEEL = 5;
    public static final int CAN_ID_ELEVATOR = 6;

  /* PWM Ports */
    public static final int PWM_ROLLER_INNER = 0;
    public static final int PWM_ROLLER_OUTER = 1;
    public static final int PWN_ARM_ACTUATOR = 2;
    public static final int PWM_PUMP_1 = 3;
    public static final int PWM_PUMP_2 = 4;
    public static final int PWM_SERVO_LEFT = 8;
    public static final int PWM_SERVO_RIGHT = 9;

  /* Relay Ports */
    public static final int RELAY_SPIKE_LEFT = 0;
    public static final int RELAY_SPIKE_RIGHT = 1;

  /* Analog Out Ports */
    public static final int LEFT_IR = 0;
    public static final int MIDDLE_IR = 1;
    public static final int RIGHT_IR = 2;

  /* Digital In Ports */
    public static final int ULTRASOUND_IN = 1;

  /* Digital Output Ports */
    public static final int ULTRASOUND_OUT = 0;

  /* Pneumatic Control IDs */
    public static final int WHEELDROP_PCM_ID_UP = 2;
    public static final int WHEELDROP_PCM_ID_DOWN = 3;
    public static final int SOLE_GEARSHIFT_LOW = 0;
    public static final int SOLE_GEARSHIFT_HIGH = 1;

  /*Arm */
    public static final int ANGLER_ID = 6;
    public static final int ARM_STARTING_POSITION = 0; //17158 //raw sensor units
    public static final double ARM_POSITION_0 = 0; // 0 degrees on arm gear
    public static final double ARM_POSITION_1 = 548; // 20 degrees on arm gear
    public static final double ARM_POSITION_2 = 1508; // 55 degrees on arm gear



  /* Joysticks */
    public static final int JOYSTICK_A_ID = 0;
    public static final Joystick JOYSTICK_A = new Joystick(JOYSTICK_A_ID);
    public static final int JOYSTICK_B_ID = 1;
    public static final Joystick JOYSTICK_B = new Joystick(JOYSTICK_B_ID);

  /* Joystick Button */
    //Drive Train
      public static final JoystickButton WHEEL_UP = new JoystickButton(JOYSTICK_A, BUTTON_ID_WHEEL_UP);
      public static final JoystickButton WHEEL_DOWN = new JoystickButton(JOYSTICK_A, BUTTON_ID_WHEEL_DOWN);
      public static final JoystickButton GEARSHIFT = new JoystickButton(JOYSTICK_A, BUTTON_ID_GEARSHIFT);

    //Suction Buttons
      public static final JoystickButton SUCC_CONTROL = new JoystickButton(JOYSTICK_A, BUTTON_ID_SUCC_CONTROL);
      public static final JoystickButton SUCC_UP = new JoystickButton(JOYSTICK_A, BUTTON_ID_SUCC_UP);
      public static final JoystickButton SUCC_DOWN = new JoystickButton(JOYSTICK_A, BUTTON_ID_SUCC_DOWN);

    //Lifter Arm Buttons
      public static final JoystickButton CHANGE_ARM_ANGLE_0 = new JoystickButton(JOYSTICK_A, BUTTON_ID_CHANGE_ARM_ANGLE_0);
      public static final JoystickButton CHANGE_ARM_ANGLE_1 = new JoystickButton(JOYSTICK_A, BUTTON_ID_CHANGE_ARM_ANGLE_1);
      public static final JoystickButton CHANGE_ARM_ANGLE_2 = new JoystickButton(JOYSTICK_A, BUTTON_ID_CHANGE_ARM_ANGLE_2);

    //Elevator Buttons
      public static final JoystickButton ELEV_UP_BUTTON = new JoystickButton(JOYSTICK_A, BUTTON_ID_ELEV_UP_BUTTON);
      public static final JoystickButton ELEV_DOWN_BUTTON = new JoystickButton(JOYSTICK_A, BUTTON_ID_ELEV_DOWN_BUTTON);

  /** -- Relative Distances in Inches to Set Elevator Heights --
   * These numbers represent how many inches the elevator would have to
   * travel in order to reach the stated height, given that the elevator starts at its
   * lowest possible height. These will be converted to rotations in the command classes.
   *
   * desiredPos doubles:
   * 0 = lowest hatch panel dropoff
   * 1 = lowest fuel dropoff
   * 2 = middle hatch panel dropoff
   * 3 = middle fuel dropoff
   * 4 = highest hatch panel dropoff
   * 5 = highest fuel dropoff
   */

  public static final double[] ELEV_INCHES = {
    0.0, //always set to zero - other measurements are relative to this height
    8.5,
    26.0,
    34.5,
    52.0,
    60.5
  };

  /* Values for the elevator */
    public static final int ELEV_LO_PANEL = 0;
    public static final int ELEV_LO_FUEL = 1;
    public static final int ELEV_MI_PANEL = 2;
    public static final int ELEV_MI_FUEL = 3;
    public static final int ELEV_HI_PANEL = 4;
    public static final int ELEV_HI_FUEL = 5;

}