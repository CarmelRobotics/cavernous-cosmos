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
 


  // -- Other Public Variables --

  public static boolean WHEEL_DROPPED = false;

  // -- Pneumatic Control IDs --

  //Wheel Dropper
  public static final int DROP_PCM_ID_UP = 2;
  public static final int DROP_PCM_ID_DOWN = 3;
  //Compresser

  public static final int COMPRESSOR_PCM_ID = 0;

  //Drivetrain
  public static final int SOLE_GEARSHIFT_LOW = 0;
  public static final int SOLE_GEARSHIFT_HIGH = 1;



//Arm
  public static final int ANGLER_ID = 6;
  public static final int ARM_STARTING_POSITION = 0; //17158 //raw sensor units
  public static final double ARM_POSITION_0 = 0; // 0 degrees on arm gear 
  public static final double ARM_POSITION_1 = 548; // 20 degrees on arm gear 
  public static final double ARM_POSITION_2 = 1508; // 55 degrees on arm gear

  //Sucker
  public static final int RELAY_ID = 0; 
  public static final int SERVO_LEFT = 5; 
  public static final int SERVO_RIGHT = 6; 

// -- Spark CAN IDs --

  public static final int CAN_ID_FRONT_RIGHT = 3;
  public static final int CAN_ID_BACK_RIGHT = 1;
  public static final int CAN_ID_FRONT_LEFT = 4;
  public static final int CAN_ID_BACK_LEFT = 2;
  public static final int CAN_ID_DROPWHEEL = 5;
  public static final int CAN_ID_ELEVATOR = 6;



// -- Analog Input Ports --
  public static final int LEFT_IR = 0;
  public static final int MIDDLE_IR = 1;
  public static final int RIGHT_IR = 2;

// -- Digital Input Ports --
  public static final int ULTRASOUND_IN = 1;

// -- Digital Output Ports --
  public static final int ULTRASOUND_OUT = 0;


//--

  // -- Joystick --

  public static final int JOYSTICK_A_ID = 0;
  public static final Joystick JOYSTICK_A = new Joystick(JOYSTICK_A_ID);
  public static final int JOYSTICK_B_ID = 1;
  public static final Joystick JOYSTICK_B = new Joystick(JOYSTICK_B_ID);

  // -- Joystick Button --



  //Drive Train
  public static final JoystickButton WHEEL_UP = new JoystickButton(JOYSTICK_A, 2);
  public static final JoystickButton WHEEL_DOWN = new JoystickButton(JOYSTICK_A, 3);
  public static final JoystickButton GEARSHIFT_UP = new JoystickButton(JOYSTICK_A, 8);
  public static final JoystickButton GEARSHIFT_DOWN = new JoystickButton(JOYSTICK_A, 9);

  //Suction Buttons
  public static final JoystickButton SUCC_ON = new JoystickButton(JOYSTICK_A, 4);
  public static final JoystickButton SUCC_OFF = new JoystickButton(JOYSTICK_A, 5);
 // public static final JoystickButton SUCC_UP = new JoystickButton(JOYSTICK_A, 6);
  //public static final JoystickButton SUCC_DOWN = new JoystickButton(JOYSTICK_A, 7);

  //Lifter Arm Buttons
  public static final JoystickButton CHANGE_ARM_ANGLE_0 = new JoystickButton(JOYSTICK_A, 10);
  public static final JoystickButton CHANGE_ARM_ANGLE_1 = new JoystickButton(JOYSTICK_A, 11);
  public static final JoystickButton CHANGE_ARM_ANGLE_2 = new JoystickButton(JOYSTICK_A, 12);

  //Elevator Buttons
 // public static final JoystickButton ELEV_UP_BUTTON = new JoystickButton(JOYSTICK_A, 3);
 // public static final JoystickButton ELEV_DOWN_BUTTON = new JoystickButton(JOYSTICK_A, 2);
 // public static final JoystickButton ELEV_LOW_BUTTON = new JoystickButton(JOYSTICK_B, 4);
 // public static final JoystickButton ELEV_MID_BUTTON = new JoystickButton(JOYSTICK_B, 5);
  //public static final JoystickButton ELEV_HIGH_BUTTON = new JoystickButton(JOYSTICK_B, 6);
 // public static final JoystickButton ELEV_HATCH_BUTTON = new JoystickButton(JOYSTICK_B, 7);
  //public static final JoystickButton ELEV_FUEL_BUTTON = new JoystickButton(JOYSTICK_B, 8);
  public static final JoystickButton ELEV_UP_BUTTON = new JoystickButton(JOYSTICK_A, 7);
  public static final JoystickButton ELEV_DOWN_BUTTON = new JoystickButton(JOYSTICK_A, 6);

  


// -- Relative Distances in Inches to Set Elevator Heights --
/**
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
 
//Values for the elevator
public static final int ELEV_LO_PANEL = 0;
public static final int ELEV_LO_FUEL = 1;
public static final int ELEV_MI_PANEL = 2;
public static final int ELEV_MI_FUEL = 3;
public static final int ELEV_HI_PANEL = 4;
public static final int ELEV_HI_FUEL = 5;



}