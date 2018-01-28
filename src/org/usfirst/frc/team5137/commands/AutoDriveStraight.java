package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveStraight extends Command {
	
	public AutoDriveStraight() {
		requires(Robot.driveBase);
	}
	
	protected void execute() {
		Robot.driveBase.autoDriveStraight();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.driveBase.stop();
	}
	
	protected void interrupted() {
		end();
	}
	
}
