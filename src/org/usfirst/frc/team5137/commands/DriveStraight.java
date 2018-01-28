package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command{
	

	public DriveStraight() {
		requires(Robot.driveBase);
		
	}
	
	protected void execute() {
		Robot.driveBase.driveStraight();
		
	}
	protected void interrupted() {
		Robot.driveBase.stop();
	}
	protected void stop() {
		Robot.driveBase.stop();
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
