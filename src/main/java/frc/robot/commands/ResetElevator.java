package frc.robot.commands;



import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

import frc.robot.RobotMap;

import frc.robot.subsystems.Elevator;



public class ResetElevator extends Command {



  private Elevator el;



  public ResetElevator() {

    

    el = Robot.m_el;



    // Use requires() here to declare subsystem dependencies

    // eg. requires(chassis);

    requires(el);

  }



  // Called just before this Command runs the first time

  @Override

  protected void initialize() {

  }



  // Called repeatedly when this Command is scheduled to run

  @Override

  protected void execute() {

    el.setElevatorMovement(12); //RPM

    System.out.println("hello");

  }



  // Make this return true when this Command no longer needs to run execute()

  @Override

  protected boolean isFinished() {

    //if(el.getElevatorLimitSwitch())

      return false;

    //return true;

  }



  // Called once after isFinished returns true

  @Override

  protected void end() {

    el.setElevatorVelocity(0.0);

    el.setElevatorRelativePos(RobotMap.ELEV_LO_PANEL);

    el.setRelativeZero(el.getElevatorActualEncoderPos());

  }



  // Called when another command which requires one or more of the same

  // subsystems is scheduled to run

  @Override

  protected void interrupted() {

  }

}