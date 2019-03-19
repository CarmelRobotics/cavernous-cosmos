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
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Relay.Value;
/**
 * Compressor for the pneumatics.
 */
public class Vacuum extends Subsystem {
    public Relay spike1;
    public Relay spike2;
    public Servo servoLeft;
    public Servo servoRight;
    private VictorSP leftPump;
    private VictorSP rightPump;

    public boolean isSuckerStart = true;
    public boolean isSuckerDown = false;
    public Vacuum() {
        spike1 = new Relay(RobotMap.RELAY_SPIKE_LEFT);
        spike2 = new Relay(RobotMap.RELAY_SPIKE_RIGHT);
        servoLeft = new Servo(RobotMap.PWM_SERVO_LEFT);
        servoRight = new Servo(RobotMap.PWM_SERVO_RIGHT);
        leftPump = new VictorSP(RobotMap.PWM_PUMP_1);
        rightPump = new VictorSP(RobotMap.PWM_PUMP_2);
        

        servoRight.set(0); 
        servoLeft.set(1);
        //The pumps need to be set to on at the start
        spike1.set(Value.kOn);
        spike2.set(Value.kOn);
    }
    
    public void suckerOut() {
        isSuckerStart = true;
        isSuckerDown = false; //
        servoRight.set(0);   //  Start position for the robot //0
        servoLeft.set(1);  //Start position for the robot //1
    
       // System.out.println("Right " + servoRight.getPosition());
       // System.out.println("Left " + servoLeft.getPosition());
        spike1.set(Value.kOn);
        spike2.set(Value.kOn);
        leftPump.set(0);
        rightPump.set(0);
    }
    public void suckerIn() {
        isSuckerStart = false;
        isSuckerDown = true;
        servoRight.set(1);  //RESET TO 1
        servoLeft.set(0); //0
        spike1.set(Value.kOff);
        spike2.set(Value.kOff);
        //Pumps go on when sucker goes in
        leftPump.set(.5);
        rightPump.set(.5);
        
    }
    

	@Override
	protected void initDefaultCommand() {
    }
}
