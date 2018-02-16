package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseIntake extends Command {

	public RaiseIntake() {
		requires(Robot.intakeNoun);
	}
	
	protected void execute() {
		Robot.intakeNoun.raiseIntake();
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
