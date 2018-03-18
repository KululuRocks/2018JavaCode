package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/* Tank drive is a form of driving...
 * That disables the slide drive and assigns the drive motors to
 * a joystick each.
 */
public class TankDrive extends Command {
	
	public TankDrive() {
		requires(Robot.driveBase);
	}
	
	protected void execute() {
		Robot.driveBase.tankDrive(Robot.oi.jackBlack);
	}

	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Robot.driveBase.stop();
	}

	protected boolean isFinished() {
		return false;
	}
	
}
