package org.usfirst.frc.team5137.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {

	public static Spark leftDriveMotor;
	public static Spark rightDriveMotor;
	public static DifferentialDrive hotWheels;
	public static Spark slideDriveMotor;
	public static ADXRS450_Gyro gyro;
	
	public static void init() {
		leftDriveMotor = new Spark(1);
		rightDriveMotor = new Spark(0);
		hotWheels = new DifferentialDrive(leftDriveMotor, rightDriveMotor);
	 	hotWheels.setExpiration(.1);
	 	hotWheels.setMaxOutput(1);
		slideDriveMotor = new Spark(2);
		slideDriveMotor.setInverted(true);
		gyro = new ADXRS450_Gyro();
	}
}
