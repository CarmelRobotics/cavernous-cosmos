/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
  
public class BallIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private VictorSP intakeScOne;
  private VictorSP intakeScTwo;
  private DigitalInput stopLimit;

  public BallIntake(){
    intakeScOne = new VictorSP(RobotMap.PWM_ROLLER_INNER);
    intakeScTwo = new VictorSP(RobotMap.PWM_ROLLER_OUTER);
    stopLimit = new DigitalInput(RobotMap.INTAKE_STOP_LIMIT);

  }

  @Override
  protected void initDefaultCommand() {
  }

  public void intakeIn(){
    if(stopLimit.get()){ // if the limit is pressed it won't intake
      intakeScOne.set(-1);
      intakeScTwo.set(-.3);
    }
  }

  public void intakeOff(){
    intakeScOne.set(0);
    intakeScTwo.set(0);
   
  }
  
  public void intakeOut(){
    intakeScOne.set(1);
    intakeScTwo.set(1);
    
  }

}