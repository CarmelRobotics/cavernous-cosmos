/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import frc.robot.commands.*;

<<<<<<< HEAD


=======
>>>>>>> bd719b386d0ccd414f0b318033cc7585cac43aa6
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

    //Button Commands
    wheelUp.whenPressed(new WheelUp());
    wheelDown.whenPressed(new WheelDown());
    succOn.whenPressed(new SuccOn());
    succOff.whenPressed(new SuccOff());
    System.out.println("init complete!");
  }   

  
}
