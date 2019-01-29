/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
<<<<<<< HEAD
  /*DIO*/
	public static final int LEFT_IR = 0;
  public static final int MIDDLE_IR = 1;
  public static final int RIGHT_IR = 2;
  
=======
  // -- Other Public Variables --
  public static boolean WHEEL_DROPPED = false;
  // -- Pneumatic Control IDs --
  public static final int DROP_PCM_ID_UP = 0;
  public static final int DROP_PCM_ID_DOWN = 0;
  public static final int COMPRESSOR_PCM_ID = 0;

  // -- Joystick --
  public static final int JOYSTICK_A_ID = 0;
  public static final Joystick JOYSTICK_A = new Joystick(JOYSTICK_A_ID);
  public static final int JOYSTICK_B_ID = 1;
  public static final Joystick JOYSTICK_B = new Joystick(JOYSTICK_B_ID);

  // -- Joystick Button --
  public static final JoystickButton DOWN_BUTTON = new JoystickButton(JOYSTICK_A, 2);
  public static final JoystickButton UP_BUTTON = new JoystickButton(JOYSTICK_A, 3);
  // -- SpeedController CAN IDs --
  public static final int CAN_ID_MIDWHEEL = 0;
  // TODO: Get correct CAN ID

>>>>>>> origin/robert
}
