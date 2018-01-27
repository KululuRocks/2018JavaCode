package org.usfirst.frc.team5137.subsystems;

import org.usfirst.frc.team5137.commands.ArcadeDrive;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {

	Spark leftDriveMotor = RobotMap.leftDriveMotor;
	Spark rightDriveMotor = RobotMap.rightDriveMotor;
	Spark slideDriveMotor = RobotMap.slideDriveMotor;
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
	
	public void arcadeDrive(Joystick jackBlack) {
		leftDriveMotor.set(jackBlack.getRawAxis(1) + 0.5 * jackBlack.getRawAxis(4));
		rightDriveMotor.set(jackBlack.getRawAxis(1) - 0.5 * jackBlack.getRawAxis(4));
		slideDriveMotor.set(jackBlack.getRawAxis(0));
	}
	
	public void tankDrive(Joystick jackBlack) {
		leftDriveMotor.set(jackBlack.getRawAxis(1));
		rightDriveMotor.set(jackBlack.getRawAxis(5));
	}

	public void stop() {
		leftDriveMotor.set(0);
		rightDriveMotor.set(0);
		slideDriveMotor.set(0);
	}
	
}
