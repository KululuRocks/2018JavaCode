package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive  extends Command {

	public AutoDrive() {
		requires(Robot.driveBase);
	}
	public void execute() {
		if(Robot.timer.get()< 2) { 
			Robot.driveBase.driveStraight();	
		}
		else if(Robot.timer.get()< 4) {
			Robot.driveBase.lateralDrive();
		}
		else {
			Robot.driveBase.stop();		
		}
	}
	protected void interrupted() {
		Robot.driveBase.stop();
	}
	protected void stop() {
		Robot.driveBase.stop();
		
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
