/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private static Joystick jst;
  
  private static JoystickButton jst_button_u;
  private static JoystickButton jst_button_d;

  public static void initialize(){
    //Joystick inits
    jst = RobotMap.JOYSTICK_A;
    //Button inits
    jst_button_u = RobotMap.UP_BUTTON;
    jst_button_d = RobotMap.DOWN_BUTTON;

    //Button Commands
    jst_button_u.whenPressed(new WheelUp());
    jst_button_d.whenPressed(new WheelDown());
  }   

  
}
