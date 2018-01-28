package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {

	public ArcadeDrive() {
		requires(Robot.driveBase);
	}

	protected void execute() {
		Robot.driveBase.arcadeDrive(Robot.oi.jackBlack);
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
