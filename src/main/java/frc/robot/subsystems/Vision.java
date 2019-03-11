
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



public class Vision extends Subsystem {
    public static NetworkTableInstance ntinst;
    public static NetworkTable values;
    public static NetworkTableEntry objectSeen;
    public static NetworkTableEntry headingEntry;
    public static NetworkTableEntry distanceEntry;
    public static NetworkTableEntry objectYawEntry;
    
    public Vision(){

    }
    
    public void VisionPeriodic()
    {
        values = ntinst.getTable("values"); //access the vision server table
        objectSeen = values.getEntry("object");
        headingEntry = values.getEntry("heading");
        distanceEntry = values.getEntry("distance");
        objectYawEntry = values.getEntry("objectYaw");
        if(objectSeen.getBoolean(false)){ //false if not found
            System.out.println("Heading Entry: " + headingEntry.getDouble(404) + 
            "\nDistance Entry: " + distanceEntry.getDouble(404) + 
            "\nObject Yaw Entry: " + objectYawEntry.getDouble(404));
            //do stuff
        }
    }

    protected void initDefaultCommand(){
        ntinst = NetworkTableInstance.getDefault();
        ntinst.startServer(); //starts vision server
    }
}
