package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;
/* This command can be used to reset the gyro,
 * The use of the boolean 'isFinished' is to ensure that the gyro isn't
 * constantly being reset and calibrated when the button is held, 
 * and ensures it happens just once.
 */
public class ResetGyro extends Command {
	
	ADXRS450_Gyro gyro = RobotMap.gyro;
	
	boolean isFinished = false;
	
	protected void execute() {
		gyro.reset();
		isFinished = true;
	}

	protected boolean isFinished() {
		return isFinished;
	}
	
}
