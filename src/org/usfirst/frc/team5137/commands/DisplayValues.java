package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DisplayValues extends Command {
	double scaleFactor = 147;
	
	public DisplayValues() {
		
	}
	protected void execute() {
		SmartDashboard.putNumber("Angle", RobotMap.gyro.getAngle()); // sends the raw gyro value to Smart Dash
		
		
		//SmartDashboard.putNumber("Distance1", RobotMap.soundMaker1.getRangeInches()*scaleFactor);
		//SmartDashboard.putNumber("Distance2", RobotMap.soundMaker2.getRangeInches()*scaleFactor);
		//SmartDashboard.putNumber("Distance3", RobotMap.soundMaker3.getRangeInches()*scaleFactor);
		//SmartDashboard.putNumber("Distance4", RobotMap.soundMaker4.getRangeInches()*scaleFactor);
		
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
