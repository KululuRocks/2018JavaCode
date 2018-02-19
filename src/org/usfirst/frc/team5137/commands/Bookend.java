package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Bookend extends Command {

	boolean isFinished;
	
	public Bookend() {
		isFinished = false;
	}
	
	protected void execute() {
		isFinished = true;
	}

	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Robot.done = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}
	
}
