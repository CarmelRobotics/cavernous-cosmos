package frc.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANDigitalInput.LimitSwitch;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
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
    private CANEncoder extendEnc;
    private CANDigitalInput extendLimit;
    private DigitalInput bottomLimit;
    private int currentPos; //the elevator's current position
    private int desiredLevel;
    private int timesMoved;
    private double relativeZero;

    public Elevator() {
        extend = new CANSparkMax(RobotMap.CAN_ID_ELEVATOR, MotorType.kBrushless);
        extendEnc = extend.getEncoder();
        bottomLimit = new DigitalInput(RobotMap.ELEV_BOTTOM_LIMIT);
        //extendLimit = new CANDigitalInput(extend, LimitSwitch.kReverse, LimitSwitchPolarity.kNormallyClosed);
        desiredLevel = 0;
        timesMoved = 0;
        relativeZero = 0;
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

    //hello moto
    public void setMotorSpeed(double speed) {
        if(!bottomLimit.get())
            speed = Math.max(speed, 0);
        extend.set(speed);
    }

    public void setElevatorRelativePos(int pos) {
        this.currentPos = pos;
    }

    @Deprecated
    public boolean getElevatorLimitSwitch() {
        //normally closed: true means limit switch isn't active, false means it is
        return false;//extendLimit.get();
    }

    public int getDesiredLevel() {
        return desiredLevel;
    }

    public void setDesiredLevel(int dL) {
        this.desiredLevel = dL;
    }

    public int getTimesMoved() {
        return timesMoved;
    }

    public void addToTimesMoved() {
        this.timesMoved++;
    }

    public void motorStop() {
        extend.set(0);
    }

    public double convertInToRot(double inches) {
        return inches/RobotMap.IN_CONVERT; //insert conversion math here
      }

    public DigitalInput getBottomLimit() {
        return bottomLimit;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}