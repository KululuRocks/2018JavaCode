package org.usfirst.frc.team5137.subsystems;

import org.usfirst.frc.team5137.commands.ArcadeDrive;
import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {
	// Lines 14-18 are used to call all required bits into the subsystem and give them names to respond to
	Spark leftDriveMotor = RobotMap.leftDriveMotor;
	Spark rightDriveMotor = RobotMap.rightDriveMotor;
	Spark slideDriveMotor = RobotMap.slideDriveMotor;
	ADXRS450_Gyro gyro = RobotMap.gyro;
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
	/*Arcade Drive is a form of driving...
	 * That allows one joystick on a controller to control both forwards/backwards and left and right (via SlideDrive)
	 * and delegates rotation to a different joystick
	 */
	public void arcadeDrive(Joystick jackBlack) {
		double adjustedSlideJoystick = adjustJoystickValue(jackBlack.getRawAxis(0), .3);
		double adjustedArcadeJoystick = adjustJoystickValue(jackBlack.getRawAxis(1), .3);
		double adjustedTurnJoystick = adjustJoystickValue(jackBlack.getRawAxis(4), .3);
		slideDriveMotor.set(adjustedSlideJoystick);
		hotWheels.arcadeDrive(adjustedArcadeJoystick, -adjustedTurnJoystick);
//	Using the DifferentialDrive, simplifies the coding and is more accurate than coding out each drive motor
	}
	/* Tank drive is a form of driving...
	 * That disables the slide drive and assigns the drive motors to
	 * a joystick each.
	 */
	public void tankDrive(Joystick jackBlack) {
		double adjustedLeftJoystick = adjustJoystickValue(jackBlack.getRawAxis(1), .3);
		double adjustedRightJoystick = adjustJoystickValue(jackBlack.getRawAxis(5), .3);
		double adjustedSlideJoystick = adjustJoystickValue(jackBlack.getRawAxis(0), .3);
		hotWheels.tankDrive(adjustedLeftJoystick, adjustedRightJoystick);
		slideDriveMotor.set(adjustedSlideJoystick);		
	}
	//	This method works by calling upon the gyro to give a scaled turn value to the arcadeDrive
	public double turnRate(double angle) {
		
		
		double turnRate;

		if (Math.abs(angle) > 72) {
			turnRate = angle * .0056;
		} else if (Math.abs(angle) < 2) {
			turnRate = 0;
		} else {
			turnRate = Math.signum(angle) * .4;
		}
		
		/*if (angle > 135) {
			turnRate = 0.75;
		}
		else if(angle < -135) {
			turnRate = -0.75;
		}
		else if(angle > 90) {
			turnRate = 0.5;
			}
		else if(angle < -90) {
			turnRate = 0.5;
		}
		else if(angle > 45) {
			turnRate = 0.3;
		}
		else if(angle < -45) {
			turnRate = -0.3;
		}
		else if(angle > 0) {
			turnRate = 0.25;
		}
		else if(angle < 0) {
			turnRate = -0.25;
		}
		else {
			turnRate = 0;
		}*/
		return turnRate;	
	}
	
	public void driveStraight() {
		double turnRate = turnRate(gyro.getAngle());
		double speed = -0.65;
		hotWheels.arcadeDrive(speed, turnRate);
	}
	
	public void turnRight() {
		rightDriveMotor.set(.20);
		leftDriveMotor.set(-.20);
	}
	public void turnLeft() {
		rightDriveMotor.set(-.20);
		leftDriveMotor.set(.20);	
	}
	public void angle0() {
		rightDriveMotor.set(0);
		leftDriveMotor.set(0);
	}

	public void lateralDrive() {
		double angle = gyro.getAngle();
		double speed = .25;
		slideDriveMotor.set(speed);
		
		if(angle > 0) {
			turnRight();
		}
		else if (angle < 0) {
			turnLeft();
			
		}
		else if(angle == 0) {
			angle0();
				
		}		
	}
	
	public void stop() {
		slideDriveMotor.set(0);
		hotWheels.arcadeDrive(0,0);
	}

}
