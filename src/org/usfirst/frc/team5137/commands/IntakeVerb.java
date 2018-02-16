package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeVerb extends Command {

	public IntakeVerb() {
		requires(Robot.intakeNoun);
	}
	
	protected void execute() {
		Robot.intakeNoun.intake();
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
