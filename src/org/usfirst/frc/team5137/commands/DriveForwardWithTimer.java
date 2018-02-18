package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardWithTimer extends Command {

	double howLong;
	boolean isFinished;
	boolean lastCommand;
	
	public DriveForwardWithTimer(double howLong, boolean lastCommand) {
		requires(Robot.driveBase);
		this.howLong = howLong;
		this.lastCommand = lastCommand;
		isFinished = false;
	}
	
	public void execute() {
		if (Robot.timer.get() < howLong) {
			Robot.driveBase.driveStraight();
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
		if (lastCommand) Robot.done = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}
	
}
