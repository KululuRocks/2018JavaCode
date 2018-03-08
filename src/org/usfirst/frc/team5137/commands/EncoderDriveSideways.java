package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Uses encoder on the center wheel to slide left or right by a 
 * given distance at a given speed. Didn't work.
 */
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
		while (slideEncoder.getDistance() < distance) {
			SmartDashboard.putNumber("slide encoder distance", slideEncoder.getDistance());
			if (isDriveLeft) Robot.driveBase.lateralDrive(-speed);
			else Robot.driveBase.lateralDrive(speed);
		}
		isFinished = true;
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
