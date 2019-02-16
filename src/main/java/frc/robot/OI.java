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
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());


  //Declaring Buttons
  private static Button wheelUp;
  private static Button wheelDown;
  private static Button succOn;
  private static Button succOff;
  private static Button lifterArmDown;
  private static Button lifterArmUp;
  private static Button suckerUp;
  private static Button suckerDown;
  //Declaring Local Joysticks
  private static Joystick jStick_A;
  private static Joystick jStick_B;
  
  public static void initialize() {

     //Joystick inits
     jStick_A = RobotMap.JOYSTICK_A;
     jStick_B = RobotMap.JOYSTICK_B;

     //Button inits
     wheelUp = RobotMap.WHEEL_UP;
     wheelDown = RobotMap.WHEEL_DOWN;
     //succOn = RobotMap.SUCC_ON;
    // succOn = RobotMap.SUCC_OFF;
      //suckerUp = RobotMap.SUCC_UP;
       //suckerDown = RobotMap.SUCC_DOWN;
    lifterArmUp =   RobotMap.LIFTERARM_FORWARD;
    lifterArmDown =   RobotMap.LIFTERARM_DOWN;
     //Elevator
    //jst_button_elevup = RobotMap.ELEV_UP_BUTTON;
   // jst_button_elevdown = RobotMap.ELEV_DOWN_BUTTON;
   /// jst_button_elevlow = RobotMap.ELEV_LOW_BUTTON;
    //jst_button_elevmid = RobotMap.ELEV_MID_BUTTON;
    //jst_button_elevhigh = RobotMap.ELEV_HIGH_BUTTON;
    //jst_button_elevhatch = RobotMap.ELEV_HATCH_BUTTON;
    //jst_button_elevfuel = RobotMap.ELEV_FUEL_BUTTON;
 
     //Button Commands
     wheelUp.whenPressed(new WheelUp());
     wheelDown.whenPressed(new WheelDown());
     //lifterArmUp.whenPressed(new LifterArmForward());
     //lifterArmDown.whenPressed(new LifterArmReverse());
    // succOn.whenPressed(new SuccOn());
     //succOff.whenPressed(new SuccOff());
     //suckerUp.whenPressed(new SuckerUp());
     //suckerUp.whenPressed(new SuckerDown());
     System.out.println("init complete!");

    //Elevator Commands
   // jst_button_elevhatch.whenPressed(new MoveElevatorPending(0));
   // jst_button_elevfuel.whenPressed(new MoveElevatorPending(1));
   // jst_button_elevlow.whenPressed(new MoveElevatorPending(0));
    //jst_button_elevmid.whenPressed(new MoveElevatorPending(1));
    //jst_button_elevhigh.whenPressed(new MoveElevatorPending(2));
    //jst_button_elevup.whenPressed(new MoveElevatorUp());
    //jst_button_elevdown.whenPressed(new MoveElevatorDown());
    
   
    System.out.println("init complete!");

  }

}
