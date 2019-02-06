/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
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
    private double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
    private int currentPos; //the elevator's current position

    public Elevator() {
        extend = new CANSparkMax(RobotMap.CAN_ID_ELEVATOR, MotorType.kBrushless);
        extendPID = extend.getPIDController();
        extendEnc = extend.getEncoder();

        // PID coefficients
        kP = 0.1;
        kI = 1e-4;
        kD = 1;
        kIz = 0;
        kFF = 0;
        kMaxOutput = 1;
        kMinOutput = -1;

        // set PID controller values
        extendPID.setP(kP);
        extendPID.setI(kI);
        extendPID.setD(kD);
        extendPID.setIZone(kIz);
        extendPID.setFF(kFF);
        extendPID.setOutputRange(kMinOutput, kMaxOutput);


    }

    protected double returnElevatorEncoderPos() {
        return extendEnc.getPosition();
    }

    protected void setElevatorRawPos(double rotations) {
        extendPID.setReference(rotations, ControlType.kPosition);
    }

    protected void setElevatorRelativePos(int pos) {
        this.currentPos = pos;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
