package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Displays important values on the SmartDashboard.
 */
public class DisplayValues extends Command {
	
	protected void execute() {
		SmartDashboard.putNumber("Timer", Robot.timer.get()); // displays the time in seconds
		SmartDashboard.putNumber("Slide encoder", RobotMap.slideEncoder.getDistance());
		SmartDashboard.putNumber("Left encoder", RobotMap.leftEncoder.getDistance());
	}
	
	protected boolean isFinished() {
		return false;
	}

}
