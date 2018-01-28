package org.usfirst.frc.team5137.subsystems;

import org.usfirst.frc.team5137.commands.ArcadeDrive;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {

	Spark leftDriveMotor = RobotMap.leftDriveMotor;
	Spark rightDriveMotor = RobotMap.rightDriveMotor;
	Spark slideDriveMotor = RobotMap.slideDriveMotor;
	ADXRS450_Gyro gyro = RobotMap.gyro;
	
	DifferentialDrive hotWheels = RobotMap.hotWheels;
	double Kp = 0.3;
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
	
	public void arcadeDrive(Joystick jackBlack) {
		slideDriveMotor.set(jackBlack.getRawAxis(0));
		hotWheels.arcadeDrive(jackBlack.getRawAxis(1), jackBlack.getRawAxis(4));
		}
	
	public void tankDrive(Joystick jackBlack) {
		hotWheels.tankDrive(jackBlack.getRawAxis(1), jackBlack.getRawAxis(5));
	}

	public void driveStraight() {
		double angle = gyro.getAngle();
		double speed = -0.75;
		hotWheels.arcadeDrive(speed, angle*Kp);
		
	}
	public void stop() {
		leftDriveMotor.set(0);
		rightDriveMotor.set(0);
		slideDriveMotor.set(0);
	}
	
}
