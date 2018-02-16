package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class DriveSidewaysWithEncoder extends Command {

	Encoder slideEncoder = RobotMap.slideEncoder;
	
	double distance;
	boolean isFinished;
	String gameData;
	
	public DriveSidewaysWithEncoder(double distance) {
		this.distance = distance;
		isFinished = false;
		slideEncoder.reset();
	}
	
	public void execute() {
		gameData = Robot.gameData;
		if (slideEncoder.getDistance() < distance) {
			if(gameData.length() > 0) {
			  if(gameData.charAt(0) == 'L')
			  {
				Robot.driveBase.slideLeft();
			  } else {
				Robot.driveBase.slideRight();
			  }
            }
		}
		else {
			isFinished = true;
		}
	}
	
	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return isFinished;
	}
	
	protected void end() {
		Robot.driveBase.stop();
	}
	
}
