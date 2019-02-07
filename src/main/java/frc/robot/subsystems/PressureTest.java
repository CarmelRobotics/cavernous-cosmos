package frc.robot.subsystems;






import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.command.Subsystem;



public class PressureTest extends Subsystem {

	

	private static Compressor compress;



	public PressureTest() {

		super("Compressor");

		compress = new Compressor(0);


	}





	

	public void start() {

		compress.start();

	}


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