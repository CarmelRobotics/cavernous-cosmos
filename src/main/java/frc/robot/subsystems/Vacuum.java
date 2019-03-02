/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Relay.Value;

/**
 * Compressor for the pneumatics.
 */
public class Vacuum extends Subsystem {
    private Relay spike1;
    private Relay spike2;
    private Servo servoLeft;
    private Servo servoRight;


    public Vacuum() {
        spike1 = new Relay(RobotMap.SPIKE1_RELAY_ID);
        spike2 = new Relay(RobotMap.SPIKE2_RELAY_ID);
        servoLeft = new Servo(RobotMap.SERVO_LEFT);
        servoRight = new Servo(RobotMap.SERVO_RIGHT);
    }
    
    public void suckerUp() {
       // servoRight.set(0);
       // servoLeft.set(1);

    }

    public void suckerDown() {
     //   servoRight.set(0);
      //  servoLeft.set(1);
        
    }
    
    public void Spike1Off(){
        System.out.println("off!");
        spike1.set(Value.kOff);
        //spike2.set(Value.kOff);
    }

    public void Spike1On(){
        System.out.println("on!");
        spike1.set(Value.kOn);
        //spike2.set(Value.kOn);
    }


    public void Spike2Off(){
        System.out.println("off!");
        spike1.set(Value.kOff);
        //spike2.set(Value.kOff);
    }

    public void Spike2On(){
        System.out.println("on!");
        spike2.set(Value.kOn);
        //spike2.set(Value.kOn);
    }

	@Override
	protected void initDefaultCommand() {
    }
}
