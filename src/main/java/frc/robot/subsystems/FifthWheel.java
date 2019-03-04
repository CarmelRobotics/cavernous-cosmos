/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

@Deprecated
public class FifthWheel extends Subsystem {
  private static CANSparkMax midWheel; 
  private static Joystick jStick_B;
  
  public FifthWheel(){
    midWheel = new CANSparkMax(RobotMap.CAN_ID_DROPWHEEL,MotorType.kBrushless);
    jStick_B = RobotMap.JOYSTICK_B;
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public void slideDrive(){
    midWheel.set(jStick_B.getY());
  }
}
