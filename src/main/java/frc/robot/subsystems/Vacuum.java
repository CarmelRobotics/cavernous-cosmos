/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Relay.Value;

/**
 * Compressor for the pneumatics.
 */
public class Vacuum extends Subsystem {
    private Relay spike1;
    //private Relay spike2;
    private Servo servoLeft;
    private Servo servoRight;


    public Vacuum() {
        spike1 = new Relay(0);
        servoLeft = new Servo(8);
        servoRight = new Servo(9);
    }
    
    public void suckerUp() {
       // servoRight.set(0);
       // servoLeft.set(1);

    }

    public void suckerDown() {
     //   servoRight.set(0);
      //  servoLeft.set(1);
        
    }
    
    public void off(){
        System.out.println("off!");
        spike1.set(Value.kOff);
        //spike2.set(Value.kOff);
    }

    public void on(){
        System.out.println("on!");
        spike1.set(Value.kOn);
        //spike2.set(Value.kOn);
    }

	@Override
	protected void initDefaultCommand() {
    }
}
