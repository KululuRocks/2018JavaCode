package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
 * Raises the lift subsystem. Works in auto and teleop.
 * If auto, tell it how long (we never hooked up seat
 * motor encoders). Stops if it hits upper limit switch.
 */
public class RaiseLift extends Command {

	Timer timer;
	
	double howLong;
	boolean autonomous;
	boolean timerRunning;
	boolean isFinished;
	
	public RaiseLift() {
		requires(Robot.lift);
		autonomous = false;
		isFinished = false;
	} 
	
	public RaiseLift(double howLong) {
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
			if (timer.get() < howLong && RobotMap.upperLimitSwitch.get()) { // true = not pressed, false = pressed
				Robot.lift.raiseLift();
			} else {
				isFinished = true;
			}
		} else {
			if (RobotMap.upperLimitSwitch.get()) Robot.lift.raiseLift();
			else Robot.lift.stop();
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
