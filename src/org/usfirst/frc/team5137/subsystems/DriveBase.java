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
	DifferentialDrive hotWheels = RobotMap.hotWheels;
	Spark slideDriveMotor = RobotMap.slideDriveMotor;
	ADXRS450_Gyro gyro = RobotMap.gyro;
	
	double kp = 0.3;
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
	
	/*
	public double rampUp(double joystick, double limitedJoystick) {
		if (limitedJoystick == joystick) return limitedJoystick;
		else if (Math.abs(limitedJoystick) < Math.abs(joystick)){
			double limit = .001;
			double change = joystick - limitedJoystick;
			if (change > Math.abs(limit)) {
				change = limit;
			}
			limitedJoystick += change;
			rampUp(joystick, limitedJoystick);
		} else {
			return joystick;
		}
	}*/
	
	public void arcadeDrive(Joystick jackBlack) {
		hotWheels.arcadeDrive(jackBlack.getRawAxis(1), jackBlack.getRawAxis(4));
		slideDriveMotor.set(jackBlack.getRawAxis(0));
	}
	
	public void tankDrive(Joystick jackBlack) {
		hotWheels.tankDrive(jackBlack.getRawAxis(1), jackBlack.getRawAxis(5));
		slideDriveMotor.set(jackBlack.getRawAxis(0));
	}
	
	public void autoDriveStraight() {
		double speed = -0.75;
		double angle = gyro.getAngle();
		hotWheels.arcadeDrive(speed, angle * kp);
	}

	public void stop() {
		leftDriveMotor.set(0);
		rightDriveMotor.set(0);
		slideDriveMotor.set(0);
	}
	
}
