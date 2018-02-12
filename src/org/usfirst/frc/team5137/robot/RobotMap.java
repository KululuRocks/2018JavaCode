package org.usfirst.frc.team5137.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/* The robot map is used to define and categorize all things on the robot...
 * This includes: motors, gyros and specialty things such as the
 * DifferentialDrive- This allows the drive motors (not the slidedrive) to 
 * function together and do things such as arcade drive and tank drive 
 * more readily as seen in the DriveBase code.
 */
// like in OI, all motors and such must be public to be discoverable by other subsystems
public class RobotMap {

	public static Spark leftDriveMotor;
	public static Spark rightDriveMotor;
	public static Spark slideDriveMotor;
	public static DifferentialDrive hotWheels;
	public static ADXRS450_Gyro gyro;
	
	public static void init() {
		leftDriveMotor = new Spark(0);
		leftDriveMotor.setInverted(true);
		rightDriveMotor = new Spark(1);
		rightDriveMotor.setInverted(true);
		
		slideDriveMotor = new Spark(2);
		slideDriveMotor.setInverted(true);
		
    	hotWheels = new DifferentialDrive(leftDriveMotor, rightDriveMotor);
    	gyro = new ADXRS450_Gyro();
	}
}
