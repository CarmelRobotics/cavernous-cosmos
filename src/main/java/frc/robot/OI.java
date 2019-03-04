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

  //Declaring Buttons
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
    
     suckerControl = RobotMap.SUCC_CONTROL;
       changeArmAngleTo0 = RobotMap.CHANGE_ARM_ANGLE_0;
       changeArmAngleTo1 = RobotMap.CHANGE_ARM_ANGLE_1;
       changeArmAngleTo2 = RobotMap.CHANGE_ARM_ANGLE_2;
     //Elevator
    jst_button_elevup = RobotMap.ELEV_UP_BUTTON;
   jst_button_elevdown = RobotMap.ELEV_DOWN_BUTTON;
   /// jst_button_elevlow = RobotMap.ELEV_LOW_BUTTON;
    //jst_button_elevmid = RobotMap.ELEV_MID_BUTTON;
    //jst_button_elevhigh = RobotMap.ELEV_HIGH_BUTTON;
    //jst_button_elevhatch = RobotMap.ELEV_HATCH_BUTTON;
    //jst_button_elevfuel = RobotMap.ELEV_FUEL_BUTTON;
 
    
    gearshift = RobotMap.GEARSHIFT;


     //Button Commands
     wheelUp.whenPressed(new WheelUp());
     wheelDown.whenPressed(new WheelDown());
     //lifterArmUp.whenPressed(new LifterArmForward());
     //lifterArmDown.whenPressed(new LifterArmReverse());
    
     suckerControl.whenPressed(new SuckerControl());
    ///DriveTrain
     gearshift.whenPressed(new Gearshift());
     

    //LifterArm
    changeArmAngleTo0.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_0));
		changeArmAngleTo1.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_1));
		changeArmAngleTo2.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_2));


    //Elevator Commands
   // jst_button_elevhatch.whenPressed(new MoveElevatorPending(0));
   // jst_button_elevfuel.whenPressed(new MoveElevatorPending(1));
   // jst_button_elevlow.whenPressed(new MoveElevatorPending(0));
    //jst_button_elevmid.whenPressed(new MoveElevatorPending(1));
    //jst_button_elevhigh.whenPressed(new MoveElevatorPending(2));
    jst_button_elevup.whileHeld(new MoveElevatorManual(1));
    jst_button_elevdown.whileHeld(new MoveElevatorManual(-1));
    
   
   

  }

}