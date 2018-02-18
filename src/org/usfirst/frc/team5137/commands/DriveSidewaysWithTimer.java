package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveSidewaysWithTimer extends Command {

	Timer timer;
	boolean timerRunning;
	double howLong;
	double speed;
	boolean isFinished;
	
	public DriveSidewaysWithTimer(double howLong, double speed) {
		requires(Robot.driveBase);
		timer = new Timer();
		timerRunning = false;
		this.howLong = howLong;
		this.speed = speed;
		isFinished = false;
	}
	
	public void execute() {
		if (!timerRunning) {
			timer.reset();
			timer.start();
			timerRunning = true;
		}
		if (timer.get() < howLong) {
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
		Robot.driveBase.stop();
	}

	protected boolean isFinished() {
		return isFinished;
	}
	
}
