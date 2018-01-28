package org.usfirst.frc.team5137.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {

	public static Spark leftDriveMotor;
	public static Spark rightDriveMotor;
	public static Spark slideDriveMotor;
	public static DifferentialDrive hotWheels;
	public static ADXRS450_Gyro gyro;
    
	
	public static void init() {
		leftDriveMotor = new Spark(0);
		rightDriveMotor = new Spark(1);
		
		slideDriveMotor = new Spark(2);
    	hotWheels = new DifferentialDrive(leftDriveMotor, rightDriveMotor);
    	gyro = new ADXRS450_Gyro();
    	
	}
}
