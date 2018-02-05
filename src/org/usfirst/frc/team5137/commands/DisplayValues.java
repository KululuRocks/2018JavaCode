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
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
