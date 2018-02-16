package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardWithEncoder extends Command {

	Encoder leftEncoder = RobotMap.leftEncoder;
	
	double distance;
	boolean isFinished;
	
	public DriveForwardWithEncoder(double distance) {
		this.distance = distance;
		isFinished = false;
		leftEncoder.reset();
	}
	
	public void execute() {
		if (leftEncoder.getDistance() < distance) {
			Robot.driveBase.driveStraight();
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
	
}
