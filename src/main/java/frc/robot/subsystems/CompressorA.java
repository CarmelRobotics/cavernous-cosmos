/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.RobotMap;

/**
 * Compressor for the pneumatics.
 */
public class CompressorA extends Subsystem {
	
	private static Compressor compress;

	/**
	 * Creates a new Compressor Subsystem<br>
	 * Initializes wpilib Compressor<br>
	 */
	public CompressorA() {
		super("Compressor");
		compress = new Compressor();
	}
	
	/**
	 * Starts the compressor
	 */
	public void start() {
		compress.start();
	}
	
	/**
	 * Checks the pressure switch value and turns off the compressor when it reaches that value
	 */
	public void checkPressure()
	{
		if(!compress.getPressureSwitchValue())
        {
        	if(compress.enabled())
        	{
        		compress.stop();
        	}
        }
	}


	@Override
	protected void initDefaultCommand() {

	}
}
