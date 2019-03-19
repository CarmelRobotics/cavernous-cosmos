/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
/**
 * Add your docs here.
 */
@Deprecated
public class CustomArcadeDrive {
    public SpeedController leftController;
    public SpeedController rightController;

    public SpeedControllerGroup leftControllerGroup;
    public SpeedControllerGroup rightControllerGroup;
    
    public CustomArcadeDrive(SpeedControllerGroup leftControllerGroup, SpeedControllerGroup rightControllerGroup) {
        
    }

        // Xbox Controller    
        Joystick Xbox = new Joystick(1);  
            
        // Drivetrain
        public double throttle = Xbox.getRawAxis(3);
        public double turn = applyDeadband(Xbox);
        public double leftMtr = throttle + turn;
        public double rightMtr = throttle + turn;
        //This will need to be tuned
        public double gain = 1;

        
        private double applyDeadband(Joystick Xbox) {
                if(Math.abs(Xbox.getRawAxis(1)) < 0.1) return 0;
                else return Xbox.getRawAxis(1);
        }

        private double skim(double v) {
        // gain determines how much to skim off the top
        if (v > 1.0)
            return -((v - 1.0) * gain);
        else if (v < -1.0)
            return -((v + 1.0) * gain);
        return 0;
        }
        
        public double getLeftMotor() {
            return leftMtr + skim(rightMtr);
        }
        
        public double getRightMotor() {
            return rightMtr + skim(leftMtr);
        }

}
