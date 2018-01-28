/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5137.robot;

import org.usfirst.frc.team5137.commands.DriveStraight;
import org.usfirst.frc.team5137.subsystems.DriveBase;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static DriveBase driveBase;
	public static OI oi;
	private static Timer timer = new Timer();
	
	//Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
	   	RobotMap.gyro.calibrate();
	   	
		driveBase = new DriveBase();
		/*insert poem here 
		*/
		oi = new OI();
		//autonomousCommand = new DriveStraight();
	    
	}
	
	public static void resetTimer() {
		timer.reset();
	}
	
	public void autonomousInit() {
		//if (autonomousCommand != null) autonomousCommand.start();
		timer.reset();
		timer.start();
		
	}

	public void autonomousPeriodic() {
		
		if(timer.get() <2.0) {
			driveBase.driveStraight();
			
		}
		else {
			driveBase.stop();
			
		}
	}

	    
	public void teleopInit() {
		//if (autonomousCommand != null)
		//autonomousCommand.cancel();
		   
	}
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
	}
}
