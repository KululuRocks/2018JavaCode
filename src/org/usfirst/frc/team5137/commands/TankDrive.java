package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {
	
	public TankDrive() {
		requires(Robot.driveBase);
	}
	
	protected void execute() {
		Robot.driveBase.tankDrive(Robot.oi.jackBlack);
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
