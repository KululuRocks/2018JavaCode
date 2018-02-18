package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveSidewaysWithTimer extends Command {

	double howLong;
	double speed;
	boolean isFinished;
	
	public DriveSidewaysWithTimer(double howLong, double speed) {
		requires(Robot.driveBase);
		this.howLong = howLong;
		this.speed = speed;
		isFinished = false;
	}
	
	public void execute() {
		if (Robot.timer.get() < howLong) {
			Robot.driveBase.lateralDrive(speed);
		}
		else {
			isFinished = true;
		}
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Robot.timer.reset();
		Robot.timer.start();
		Robot.driveBase.stop();
	}

	protected boolean isFinished() {
		return isFinished;
	}
	
}
