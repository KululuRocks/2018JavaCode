package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {

	public AutoDrive() {
		requires(Robot.driveBase); // tells command what subsystem it is interacting with
	}
	
	public void execute() { //what the command will do when called
		if (Robot.timer.get() < 2) { 
			Robot.driveBase.driveStraight();	
		}
		/* 3 things are happening here
		 * 1. the command is importing the timer from the Robot Class
		 * 2. it is setting an 'if' case,
		 * 3. it is running a specific method in the DriveBase while the time is below 2 seconds
		 */
		else if (Robot.timer.get() < 4) {
			Robot.driveBase.lateralDrive();
		}
		// When the timer is between 2 and 4 seconds, it will run this specific method in the drive base
		else {
			Robot.driveBase.stop();		
		}
		// When the timer counts past 4, it runs the Stop() method in the DriveBase
	}
	
	//Tells the robot what to do if it is interrupted
	protected void interrupted() {
		end();
	}
	
	//When the command is told to stop, this runs
	protected void end() {
		Robot.driveBase.stop();
	}
	
	protected boolean isFinished() {
		return false;
	}
}
