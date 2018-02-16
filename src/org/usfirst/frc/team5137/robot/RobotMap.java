package org.usfirst.frc.team5137.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
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
	public static Spark liftMotor;
	public static Spark rotateIntakeMotor;
	public static Spark intakeMotor;
	public static DifferentialDrive hotWheels;
	public static ADXRS450_Gyro gyro;
	public static Encoder leftEncoder;
	public static Encoder rightEncoder;
	public static Encoder slideEncoder;
	
	public static void init() {
		leftDriveMotor = new Spark(0);
		leftDriveMotor.setInverted(true);
		
		rightDriveMotor = new Spark(1);
		rightDriveMotor.setInverted(true);
		
		hotWheels = new DifferentialDrive(leftDriveMotor, rightDriveMotor);
		
		slideDriveMotor = new Spark(2);
		liftMotor = new Spark(3); // FIX THIS PORT
		
		rotateIntakeMotor = new Spark(4); // AND THIS ONE
		intakeMotor = new Spark(5); // AND ALSO THIS ONE
	
    		gyro = new ADXRS450_Gyro();
    		
    		leftEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
    		leftEncoder.setDistancePerPulse(5); // TOTALLY arbitrary
    		leftEncoder.setMinRate(10); // also arbitrary
    		
    		rightEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
    		rightEncoder.setDistancePerPulse(5);
    		rightEncoder.setMinRate(10);
    		
    		slideEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
    		slideEncoder.setDistancePerPulse(5);
    		slideEncoder.setMinRate(10);
	}
	
	
}
