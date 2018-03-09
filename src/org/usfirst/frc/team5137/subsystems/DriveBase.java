package org.usfirst.frc.team5137.subsystems;

import org.usfirst.frc.team5137.commands.ArcadeDrive;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {
	// Lines 14-19 are used to call all required bits into the subsystem and give them names to respond to
	Spark leftDriveMotor = RobotMap.leftDriveMotor;
	Spark rightDriveMotor = RobotMap.rightDriveMotor;
	Spark slideDriveMotor = RobotMap.slideDriveMotor;
	DifferentialDrive hotWheels = RobotMap.hotWheels;

	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
	
	//	An algorithm developed by the fantastic Sarah C. Lincoln that adjusts the joysticks
	//	to run scaled to the deadZone
	public double adjustJoystickValue(double joystick, double deadZone) {
		double adjustedJoystick;
		if (Math.abs(joystick) < deadZone) {
			adjustedJoystick = 0;
		} else {
			adjustedJoystick = ((1 / (1 - deadZone)) * (joystick - deadZone));
		}
		return adjustedJoystick;
	}
	
	/* 
	 * Arcade Drive is a form of driving...
	 * That allows one joystick on a controller to control both forwards/backwards and left and right (via SlideDrive)
	 * and delegates rotation to a different joystick
	 */
	public void arcadeDrive(Joystick jackBlack) {
	   /*
        * x' = a(x^b) + (1-a)x
        *
        * x' is the scaled output value
        * a is the vertical/horizontal stretch
        * x is the raw value input from the axis
        * as a approaches 0, the ramp approaches a linear (y=x) ramp
        * as a approaches 1 the ramp approaches an exponential ramp
        * increasing the b makes the ramp's severity lower
        * (it takes more to move the stick for it to reach its full value)
        * (looks like a x^b)
        * decreasing the b between 1 and 0 makes the ramp's severity higher
        * (looks like a root x )
        * don't make a negative. that is NOT GOOD
        */
        
		/*
        double rawArcade = jackBlack.getRawAxis(1);
        double rawSlide = jackBlack.getRawAxis(0);
        double rawTurn = jackBlack.getRawAxis(4);
        */
        
        // dead zone included
        double rawArcade = adjustJoystickValue(jackBlack.getRawAxis(1), .2);
        double rawSlide = adjustJoystickValue(jackBlack.getRawAxis(0), .2);
        double rawTurn = adjustJoystickValue(jackBlack.getRawAxis(4), .2); 
        
        double sensitivityArcade = .95;
        double sensitivitySlide = .95;
        double sensitivityTurn = .95;
        
        double exponentialArcadeDrive;
        double exponentialSlideDrive;
        double exponentialTurn;
        
        double sensitivityExponent = 3;
        
        exponentialArcadeDrive = (sensitivityArcade*(Math.pow(rawArcade, sensitivityExponent))) + ((1-sensitivityArcade)*rawArcade);
        exponentialSlideDrive =  (sensitivitySlide*(Math.pow(rawSlide, sensitivityExponent))) + ((1-sensitivitySlide)*rawSlide);
        exponentialTurn = -1*(sensitivityTurn*(Math.pow(rawTurn, sensitivityExponent))) + ((1-sensitivityTurn)*rawTurn);
        
        hotWheels.arcadeDrive(exponentialArcadeDrive, exponentialTurn);
        slideDriveMotor.set(exponentialSlideDrive);
	}
	
	public void lateralDrive(double speed) {
		slideDriveMotor.set(speed);
	}
	
	public void driveStraight(double speed) {
		hotWheels.arcadeDrive(-speed, 0);
	}
	
	public void stop() {
		slideDriveMotor.set(0);
		hotWheels.arcadeDrive(0, 0);
	}

}
