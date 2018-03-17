package org.usfirst.frc.team5137.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {
	
	Timer timer;
	
	boolean timerRunning;
	double howLong;
	double speed;
	boolean isFinished;
	
	public Wait(double howLong) {
		timer = new Timer();
		timerRunning = false;
		this.howLong = howLong;
		isFinished = false;
	}
	
	public void execute() {
		if (!timerRunning) {
			timer.reset();
			timer.start();
			timerRunning = true;
		}
		if (timer.get() < howLong) {
			;
		}
		else {
			isFinished = true;
		}
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		;
	}

	protected boolean isFinished() {
		return isFinished;
	}

}
