package org.usfirst.frc.team5137.commands;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderPivot extends Command implements RepeatsInTeleop {

	Encoder leftEncoder = RobotMap.leftEncoder;
	Encoder rightEncoder = RobotMap.rightEncoder;
	
	double distance;
	double speed;
	boolean isLeft;
	boolean isFinished;
	boolean isReset;
	
	public EncoderPivot(double distance, double speed) {
		requires(Robot.driveBase);
		this.distance = distance;
		this.speed = speed;
		isLeft = false;
		isReset = false;
		isFinished = false;
	}
	
	public void execute() {
		if (!isReset) {
			reset();
			isReset = true;
		}
		if (isLeft) {
			if (Math.abs(leftEncoder.getDistance()) < distance) {
				Robot.driveBase.pivot(-speed);
			} else isFinished = true;	
		} else {
			if (Math.abs(rightEncoder.getDistance()) < distance) {
				Robot.driveBase.pivot(speed);
			} else isFinished = true;
		}
	}
	
	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return isFinished;
	}
	
	protected void end() {
		leftEncoder.reset();
		rightEncoder.reset();
		Robot.driveBase.stop();
	}
	
	public void reset() {
		leftEncoder.reset();
		rightEncoder.reset();
		isFinished = false;
	}
	
	public void setDirection(boolean isLeft) {
		this.isLeft = isLeft;
	}
	
}
