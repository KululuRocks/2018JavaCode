package org.usfirst.frc.team5137.robot;

import edu.wpi.first.wpilibj.Spark;

public class RobotMap {

	public static Spark leftDriveMotor;
	public static Spark rightDriveMotor;
	public static Spark slideDriveMotor;
	
	public static void init() {
		leftDriveMotor = new Spark(0);
		leftDriveMotor.setInverted(true);
		rightDriveMotor = new Spark(1);
		slideDriveMotor = new Spark(2);
	}
}
