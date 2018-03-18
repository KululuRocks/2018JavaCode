package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LowerLift extends Command {

	Timer timer;
	double howLong;
	boolean autonomous;
	boolean timerRunning;
	boolean isFinished;
	
	public LowerLift() {
		requires(Robot.lift);
		autonomous = false;
		isFinished = false;
	} 
	
	public LowerLift(double howLong) {
		requires(Robot.lift);
		timer = new Timer();
		this.howLong = howLong;
		autonomous = true;
		timerRunning = false;
		isFinished = false;
	}
	
	protected void execute() {
		if (autonomous) {
			if (!timerRunning) {
				timer.reset();
				timer.start();
				timerRunning = true;
			}
			if (timer.get() < howLong) {
				Robot.lift.lowerLift();
			} else {
				isFinished = true;
			}
		} else {
			Robot.lift.lowerLift();
		}
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Robot.lift.stop();
	}
	
	protected boolean isFinished() {
		return isFinished;
	}
	
}
