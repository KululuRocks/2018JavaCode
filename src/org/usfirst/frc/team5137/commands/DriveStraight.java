package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {

	/* This command is practically the same as AutoDrive with out the timer based code,
	The point of it is to check the gyro during teleOp to help with debugging
	*/
	
	public DriveStraight() {
		requires(Robot.driveBase);	
	}
	
	public void execute() {
		Robot.driveBase.driveStraight();
	}
	
	protected void interrupted() {
		Robot.driveBase.stop();
	}
	
	protected void stop() {
		Robot.driveBase.stop();
		
	}
	
	
	protected boolean isFinished() {
		return false;
	}

}
