package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderDriveSideways extends Command {

	Encoder slideEncoder = RobotMap.slideEncoder;
	
	double distance;
	double speed;
	boolean isDriveLeft;
	boolean isFinished;
	
	public EncoderDriveSideways(double distance, double speed) {
		requires(Robot.driveBase);
		this.distance = distance;
		this.speed = speed;
		isFinished = false;
		slideEncoder.reset();
	}
	
	public void execute() {
		if (slideEncoder.getDistance() < distance) {
			if (isDriveLeft) Robot.driveBase.lateralDrive(-speed);
			else Robot.driveBase.lateralDrive(speed);
		}
		else {
			isFinished = true;
		}
	}
	
	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return isFinished;
	}
	
	protected void end() {
		Robot.driveBase.stop();
	}
	
	public void setDriveDirection(boolean isDriveLeft) {
		this.isDriveLeft = isDriveLeft;
	}
	
}