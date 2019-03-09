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
  private VictorSP intakeScThree;
  private VictorSP intakeScFour;

  public BallIntake(){
    intakeScOne = new VictorSP(RobotMap.INTAKE_IDs[0]);
    intakeScTwo = new VictorSP(RobotMap.INTAKE_IDs[1]);
    intakeScThree = new VictorSP(RobotMap.INTAKE_IDs[2]);
    intakeScFour = new VictorSP(RobotMap.INTAKE_IDs[3]);


  }

  @Override
  protected void initDefaultCommand() {
  }

  public void intakeIn(){
    
    intakeScOne.set(1);
    intakeScTwo.set(1);
    intakeScThree.set(1);
    intakeScFour.set(1);
    
  }

  public void intakeOff(){
    intakeScOne.set(0);
    intakeScTwo.set(0);
    intakeScThree.set(0);
    intakeScFour.set(0);
  }
  
  public void intakeOut(){
    intakeScOne.set(-1);
    intakeScTwo.set(-1);
    intakeScThree.set(-1);
    intakeScFour.set(-1);
  }

}