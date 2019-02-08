/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import frc.robot.commands.*;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused") // https://i.imgur.com/5tTlHDT.jpg
public class OI {
  private static Joystick jStick_A;
  private static Joystick jStick_B;
  
  private static JoystickButton jst_button_u;
  private static JoystickButton jst_button_d;
  private static JoystickButton jst_button_elevup;
  private static JoystickButton jst_button_elevdown;
  private static JoystickButton jst_button_elevlow;
  private static JoystickButton jst_button_elevmid;
  private static JoystickButton jst_button_elevhigh;
  private static JoystickButton jst_button_elevhatch;
  private static JoystickButton jst_button_elevfuel;
  private static Button wheelUp;
  private static Button wheelDown;
  private static Button succOn;
  private static Button succOff;

  public static void initialize(){
    //Joystick inits
    jStick_A = RobotMap.JOYSTICK_A;
    jStick_B = RobotMap.JOYSTICK_B;
    //Button inits
    wheelUp = RobotMap.WHEEL_UP;
    wheelDown = RobotMap.WHEEL_DOWN;
    succOn = RobotMap.SUCC_ON;
    succOn = RobotMap.SUCC_OFF;

    jst_button_elevup = RobotMap.ELEV_UP_BUTTON;
    jst_button_elevdown = RobotMap.ELEV_DOWN_BUTTON;
    jst_button_elevlow = RobotMap.ELEV_LOW_BUTTON;
    jst_button_elevmid = RobotMap.ELEV_MID_BUTTON;
    jst_button_elevhigh = RobotMap.ELEV_HIGH_BUTTON;
    jst_button_elevhatch = RobotMap.ELEV_HATCH_BUTTON;
    jst_button_elevfuel = RobotMap.ELEV_FUEL_BUTTON;

    //Button Commands
    jst_button_u.whenPressed(new WheelUp());
    jst_button_d.whenPressed(new WheelDown());
    jst_button_elevhatch.whenPressed(new MoveElevatorPending(0));
    jst_button_elevfuel.whenPressed(new MoveElevatorPending(1));
    jst_button_elevlow.whenPressed(new MoveElevatorPending(0));
    jst_button_elevmid.whenPressed(new MoveElevatorPending(1));
    jst_button_elevhigh.whenPressed(new MoveElevatorPending(2));
    jst_button_elevup.whenPressed(new MoveElevatorUp());
    jst_button_elevdown.whenPressed(new MoveElevatorDown());
    wheelUp.whenPressed(new WheelUp());
    wheelDown.whenPressed(new WheelDown());
    //succOn.whenPressed(new SuccOn());
    //succOff.whenPressed(new SuccOff());
    System.out.println("init complete!");
  }   

}
