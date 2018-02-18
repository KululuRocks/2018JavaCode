package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardWithTimer extends Command {

	Timer timer;
	boolean timerRunning;
	double howLong;
	boolean lastCommand;
	boolean isFinished;
	
	public DriveForwardWithTimer(double howLong, boolean lastCommand) {
		requires(Robot.driveBase);
		timer = new Timer();
		timerRunning = false;
		this.howLong = howLong;
		this.lastCommand = lastCommand;
		isFinished = false;
	}
	
	public void execute() {
		if (!timerRunning) {
			timer.reset();
			timer.start();
			timerRunning = true;
		}
		if (timer.get() < howLong) {
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
		Robot.driveBase.stop();
		if (lastCommand) Robot.done = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}
	
}
