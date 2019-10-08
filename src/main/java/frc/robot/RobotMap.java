/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.JoystickBase;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  /* Other Public Variables */
    public static boolean WHEEL_DROPPED = false;
    public static double IN_CONVERT = 7.2;
    public static boolean SHIFTER_HIGH = false;
    public static boolean PISTON_OUT = true;
    public static boolean ELEV_MOVING = false;

  /* Joysticks */
    public static final int JOYSTICK_A_ID = 0;
    public static final Joystick JOYSTICK_A = new Joystick(JOYSTICK_A_ID);
    public static final int GUITAR_ID = 1;
    public static final Joystick GUITAR = new Joystick(GUITAR_ID);



  /* Joystick Button IDs*/
  //BUTTONS MUST NOT BE SET TO 0. THIS WILL CAUSE AN ERROR.
    public static final int BUTTON_ID_WHEEL_UP = 4;
    public static final int BUTTON_ID_WHEEL_DOWN = 3;
    public static final int BUTTON_ID_GEARSHIFT = 1;

    public static final int BUTTON_ID_ELEV_HATCH_2 = 10;


    public static final int BUTTON_ID_SUCC_IN = 5;
    public static final int BUTTON_ID_SUCKER_OUT= 6;

    public static final int BUTTON_DRIVETRAIN_TIMER = 12;
    public static int BUTTON_APPROACH_OBJECTIVE = 11;
   

  /* Guitar Buttons */
 
  public static final int BUTTON_ID_INTAKEIN_POVBUTTON_DEGREES = 4; //Top Button
  public static final int BUTTON_ID_INTAKEOUT_POVBUTTON_DEGREES = 3; //Bottom Button
    public static final int BUTTON_ID_ELEV_UP_BUTTON = 9;
    public static final int BUTTON_ID_ELEV_DOWN_BUTTON = 8;
  public static final int BUTTON_ID_CHANGE_ARM_ANGLE_0 = 5;
  public static final int BUTTON_ID_CHANGE_ARM_ANGLE_1 = 7;
  public static final int BUTTON_ID_CHANGE_ARM_ANGLE_2 = 6;
  public static final int BUTTON_ID_MANUAL_LIFTERARM_UP_BUTTON = 1;
  public static final int BUTTON_ID_MANUAL_LIFTERARM_DOWN_BUTTON = 2;
 

  /* Spark CAN IDs */
    public static final int CAN_ID_FRONT_RIGHT = 3;
    public static final int CAN_ID_BACK_RIGHT = 1;
    public static final int CAN_ID_FRONT_LEFT = 4; //4
    public static final int CAN_ID_BACK_LEFT = 2; //2
    public static final int CAN_ID_DROPWHEEL = 5; //5
    public static final int CAN_ID_ELEVATOR = 6; //6

  /* PWM Ports */
    public static final int PWM_ROLLER_INNER = 0;
    public static final int PWM_ROLLER_OUTER = 1;
   // public static final int PWN_ARM_ACTUATOR = 2;
    public static final int PWM_PUMP_1 = 2;

    public static final int PWM_PUMP_2 = 3;
    public static final int PWM_SERVO_LEFT = 7;
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

  /* Limit Switches */
    public static final int ELEV_BOTTOM_LIMIT = 0;
    public static final int ARM_ANGLE_LIMIT = 1;
    public static final int INTAKE_STOP_LIMIT = 2; 
    
  /* Pneumatic Control IDs */
    public static final int WHEELDROP_PCM_ID_UP = 2;
    public static final int WHEELDROP_PCM_ID_DOWN = 3;
    public static final int SOLE_GEARSHIFT_LOW = 0;
    public static final int SOLE_GEARSHIFT_HIGH = 1;

    //public static final int COMPRESSER_ID = 0;

  /*Arm */
    public static final int ANGLER_ID = 7;
    public static final int ARM_STARTING_POSITION = 0; //17158 //raw sensor units
    public static final double ARM_POSITION_0 = 0; // 0 degrees on arm gear
    public static final double ARM_POSITION_1 = 548; // 20 degrees on arm gear
    public static final double ARM_POSITION_2 = 1508; // 55 degrees on arm gear

  /* Joystick Button */
    //Drive Train
      public static final JoystickButton WHEEL_UP = new JoystickButton(JOYSTICK_A, BUTTON_ID_WHEEL_UP);
      public static final JoystickButton WHEEL_DOWN = new JoystickButton(JOYSTICK_A, BUTTON_ID_WHEEL_DOWN);
      public static final JoystickButton GEARSHIFT = new JoystickButton(JOYSTICK_A, BUTTON_ID_GEARSHIFT);

    //Suction Buttons
      public static final JoystickButton SUCC_IN = new JoystickButton(JOYSTICK_A, BUTTON_ID_SUCC_IN);
  
      public static final JoystickButton SUCC_OUT = new JoystickButton(JOYSTICK_A, BUTTON_ID_SUCKER_OUT);

    //Lifter Arm Buttons
      public static final JoystickButton CHANGE_ARM_ANGLE_0 = new JoystickButton(GUITAR, BUTTON_ID_CHANGE_ARM_ANGLE_0);
      public static final JoystickButton CHANGE_ARM_ANGLE_1 = new JoystickButton(GUITAR, BUTTON_ID_CHANGE_ARM_ANGLE_1);
      public static final JoystickButton CHANGE_ARM_ANGLE_2 = new JoystickButton(GUITAR, BUTTON_ID_CHANGE_ARM_ANGLE_2);

    //Elevator Buttons
      public static final JoystickButton ELEV_UP_BUTTON = new JoystickButton(GUITAR, BUTTON_ID_ELEV_UP_BUTTON);
      public static final JoystickButton ELEV_DOWN_BUTTON = new JoystickButton(GUITAR, BUTTON_ID_ELEV_DOWN_BUTTON);
      public static final JoystickButton ELEV_HATCH_2_BUTTON = new JoystickButton(JOYSTICK_A, BUTTON_ID_ELEV_HATCH_2);

    //Intake Buttons
    public static final JoystickButton INTAKEIN_BUTTON = new JoystickButton(GUITAR, BUTTON_ID_INTAKEIN_POVBUTTON_DEGREES);
    public static final JoystickButton INTAKEOUT_BUTTON = new JoystickButton(GUITAR, BUTTON_ID_INTAKEOUT_POVBUTTON_DEGREES);

     //LifterArm
     public static final JoystickButton MANUAL_LIFTERARM_UP_BUTTON = new JoystickButton(GUITAR, BUTTON_ID_MANUAL_LIFTERARM_UP_BUTTON);
     public static final JoystickButton MANUAL_LIFTERARM_DOWN_BUTTON  = new JoystickButton(GUITAR, BUTTON_ID_MANUAL_LIFTERARM_DOWN_BUTTON);
    
    //DriveTrain Buttons
    public static final JoystickButton TIMER_DRIVETRAIN_BUTTON = new JoystickButton(JOYSTICK_A,BUTTON_DRIVETRAIN_TIMER);
    public static final JoystickButton APPROACH_OBJECTIVE_BUTTON = new JoystickButton(JOYSTICK_A,BUTTON_APPROACH_OBJECTIVE);

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