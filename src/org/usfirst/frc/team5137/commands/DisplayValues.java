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
		SmartDashboard.putNumber("Angle", RobotMap.gyro.getAngle()); // displays the gyro angle on the SmartDashboards
		SmartDashboard.putNumber("Timer", Robot.timer.get()); // displays the time in seconds
	}
	
	protected boolean isFinished() {
		return false;
	}

}
