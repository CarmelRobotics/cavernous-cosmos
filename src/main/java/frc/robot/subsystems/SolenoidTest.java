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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;





public class SolenoidTest extends Subsystem {
  private DoubleSolenoid doubleSol;



public SolenoidTest() {



doubleSol = new DoubleSolenoid(RobotMap.channel,RobotMap.channel2);


}


public void SolenoidForward() {


doubleSol.set(Value.kForward);


}


public void SolenoidBackwards() {


  doubleSol.set(Value.kReverse);
  
  
  }

  public void SolenoidOff(){

		

		doubleSol.set(DoubleSolenoid.Value.kOff);

	}



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
