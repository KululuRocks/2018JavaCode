package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderDriveForward extends Command {

	Encoder leftEncoder = RobotMap.leftEncoder;
	
	double distance;
	double speed;
	boolean isFinished;
	
	public EncoderDriveForward(double distance, double speed) {
		requires(Robot.driveBase);
		this.distance = distance;
		this.speed = speed;
		isFinished = false;
		leftEncoder.reset();
	}
	
	public void execute() {
		if (leftEncoder.getDistance() < distance) {
			Robot.driveBase.driveStraight(speed);
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
