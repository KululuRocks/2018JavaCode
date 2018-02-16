package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerLift extends Command {

	public LowerLift() {
		requires(Robot.lift);
	}
	
	protected void execute() {
		Robot.lift.lowerLift();
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Robot.lift.stop();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
}
