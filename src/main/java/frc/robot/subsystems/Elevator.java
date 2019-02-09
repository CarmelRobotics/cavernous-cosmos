/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANDigitalInput.LimitSwitch;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Extender to carry game pieces to higher elevations.
   * desiredPos ints:
   * 0 = lowest possible height of the elevator
   * 1 = lowest hatch panel dropoff
   * 2 = lowest fuel dropoff
   * 3 = middle hatch panel dropoff
   * 4 = middle fuel dropoff
   * 5 = highest hatch panel dropoff
   * 6 = highest fuel dropoff
*/
public class Elevator extends Subsystem {

    private CANSparkMax extend;
    private CANPIDController extendPID;
    private CANEncoder extendEnc;
    private CANDigitalInput extendLimit;
    private double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
    private int currentPos; //the elevator's current position
    private int desiredLevel;
    private int timesMoved;
    private double relativeZero;

    public Elevator() {
        extend = new CANSparkMax(RobotMap.CAN_ID_ELEVATOR, MotorType.kBrushless);
        extendPID = extend.getPIDController();
        extendEnc = extend.getEncoder();
        //extendLimit = new CANDigitalInput(extend, LimitSwitch.kReverse, LimitSwitchPolarity.kNormallyClosed);
        desiredLevel = 0;
        timesMoved = 0;
        relativeZero = 0;

        // PID coefficients
        kP = 0.1;  //originally 0.1
        kI = 1e-4; //originally 1e-4
        kD = 0.5; //originally 1
        kIz = 0.5; //originally 0
        kFF = 0.5; //originally 0
        kMaxOutput = 0.1; //originally -1
        kMinOutput = -0.1; //originally 1

        // set PID controller values
        extendPID.setP(kP);
        extendPID.setI(kI);
        extendPID.setD(kD);
        extendPID.setIZone(kIz);
        extendPID.setFF(kFF);
        extendPID.setOutputRange(kMinOutput, kMaxOutput);


    }

    public double getElevatorActualEncoderPos() {
        return extendEnc.getPosition();
    }

    public double getRelativeZero() {
        return relativeZero;
    }

    public void setRelativeZero(double zero) {
        relativeZero = zero;
    }

    public void setElevatorMovement(double rotations) {
        extendPID.setReference(rotations, ControlType.kPosition);
        System.out.println("setElevatorMovement Run");
    }

    public void testMotor(double speed) {
        extend.set(speed);
    }

    public void setElevatorRelativePos(int pos) {
        this.currentPos = pos;
    }

    public void setElevatorVelocity(double rpm) {
        extendPID.setReference(rpm, ControlType.kVelocity);
    }

    public boolean getElevatorLimitSwitch() {
        //normally closed: true means limit switch isn't active, false means it is
        return false;//extendLimit.get();
    }

    public int getDesiredLevel() {
        //normally closed: true means limit switch isn't active, false means it is
        return desiredLevel;
    }

    public void setDesiredLevel(int dL) {
        //normally closed: true means limit switch isn't active, false means it is
        this.desiredLevel = dL;
    }

    public int getTimesMoved() {
        //normally closed: true means limit switch isn't active, false means it is
        return timesMoved;
    }

    public void addToTimesMoved() {
        //normally closed: true means limit switch isn't active, false means it is
        this.timesMoved++;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
