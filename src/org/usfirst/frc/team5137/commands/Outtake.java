package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Outtake extends Command {

	public Outtake() {
		requires(Robot.intakeNoun);
	}
	
	protected void execute() {
		Robot.intakeNoun.outtake();
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Robot.intakeNoun.stop();
	}
	
	protected boolean isFinished() {
		return false;
	}
}
