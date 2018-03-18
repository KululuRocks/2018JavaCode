package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class OpenIntake extends Command {

	Timer timer;
	
	double howLong;
	boolean autonomous;
	boolean timerRunning;
	boolean isFinished;
	
	// Constructor for teleop
	public OpenIntake() {
		requires(Robot.intakeNoun);
		autonomous = false;
		isFinished = false;
	} 
	
	// Constructor for autonomous
	public OpenIntake(double howLong) {
		requires(Robot.intakeNoun);
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
				Robot.intakeNoun.openIntake();
			} else {
				isFinished = true;
			}
		} else {
			Robot.intakeNoun.openIntake();
		}
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Robot.intakeNoun.stop();
	}
	
	protected boolean isFinished() {
		return isFinished;
	}
	
}
