package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {

	public ArcadeDrive() { 
		requires(Robot.driveBase); // tells the Command what to import for a subsystem
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveBase.arcadeDrive(Robot.oi.jackBlack); // Specific method in DriveBase
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.driveBase.stop();
	}

	protected boolean isFinished() {
		return false;
	}
}
