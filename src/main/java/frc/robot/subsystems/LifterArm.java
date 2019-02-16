/*----------------------------------------------------------------------------*/


/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */

/* Open Source Software - may be modified and shared by FRC teams. The code   */

/* must be accompanied by the FIRST BSD license file in the root directory of */

/* the project.                                                               */

/*----------------------------------------------------------------------------*/



package frc.robot.subsystems;



import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**

 * Used to drop the center wheel for slide drive.

 */

public class LifterArm extends Subsystem {

  // Put methods for controlling this subsystem

  // here. Call these from Commands.

  // Somebody once told me

  
  //Declaring Solenoid
  private DoubleSolenoid theFortyFiver;
  private DoubleSolenoid theGrounder;
  public Boolean isFortyFive;
  public Boolean isGrounded;


  public LifterArm() {

    //Constructing Solenoid
    theFortyFiver = new DoubleSolenoid(RobotMap.DROP_PCM_ID_UP, RobotMap.DROP_PCM_ID_DOWN);
    theGrounder = new DoubleSolenoid(RobotMap.DROP_PCM_ID_UP, RobotMap.DROP_PCM_ID_DOWN);
  }



  @Override

  public void initDefaultCommand() {

    // Set the default command for a subsystem here.

    // setDefaultCommand(new MySpecialCommand());

  }

  
//Wheel is initally up so forward puts it down in place
  public void theFortyFiverForward(){ 

    theFortyFiver.set(DoubleSolenoid.Value.kForward);
    isFortyFive = true;
    isGrounded = false;
  }

  public void theFortyFiverReverse(){ 

    theFortyFiver.set(DoubleSolenoid.Value.kReverse);
    isFortyFive = false;
    isGrounded = false;

  }

  public void theGrounderForward(){ 

    theGrounder.set(DoubleSolenoid.Value.kForward);
    isGrounded = true;
    isFortyFive = false;

  }

  public void theGrounderReverse(){ 

    theGrounder.set(DoubleSolenoid.Value.kReverse);
    isFortyFive = true;
    isGrounded = false;
  }


  



  public void stop(DoubleSolenoid sol){ 

    sol.set(DoubleSolenoid.Value.kOff);
  
  }

  public DoubleSolenoid getTheFortyFiver() {

  return theFortyFiver;
 }
  
public DoubleSolenoid getTheGrounder() {

  return theGrounder;
}



}
