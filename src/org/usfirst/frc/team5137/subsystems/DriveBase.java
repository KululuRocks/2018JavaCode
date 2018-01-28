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
	double Kp = 0.03;
	
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
	
	public double adjustJoystickValue(double joystick, double deadZone) {
		double adjustedJoystick;
		if (Math.abs(joystick) < deadZone) {
			adjustedJoystick = 0;
		} else {
			adjustedJoystick = ((1 / (1 - deadZone)) * (joystick - deadZone));
		}
		return adjustedJoystick;
	}
	
	public void arcadeDrive(Joystick jackBlack) {
		double adjustedSlideJoystick = adjustJoystickValue(jackBlack.getRawAxis(0), .2);
		double adjustedArcadeJoystick = adjustJoystickValue(jackBlack.getRawAxis(1), .2);
		double adjustedTurnJoystick = adjustJoystickValue(jackBlack.getRawAxis(4), .2);
		
		
		slideDriveMotor.set(adjustedSlideJoystick);
		hotWheels.arcadeDrive(adjustedArcadeJoystick, adjustedTurnJoystick);
	}
	
	public void tankDrive(Joystick jackBlack) {
		double adjustedLeftJoystick = adjustJoystickValue(jackBlack.getRawAxis(1), .2);
		double adjustedRightJoystick = adjustJoystickValue(jackBlack.getRawAxis(5), .2);
		double adjustedSlideJoystick = adjustJoystickValue(jackBlack.getRawAxis(0), .2);
		
		hotWheels.tankDrive(adjustedLeftJoystick, adjustedRightJoystick);
		slideDriveMotor.set(adjustedSlideJoystick);
			
	}

	public void driveStraight() {
		double angle = gyro.getAngle();
		double speed = -0.65;
		hotWheels.arcadeDrive(speed, angle*Kp);
		
	}
	
	public void slideDrive() {
		double speed = .25;
		slideDriveMotor.set(speed);
		
	}
	
	public void stop() {
		slideDriveMotor.set(0);
		hotWheels.arcadeDrive(0,0);
	}

}
