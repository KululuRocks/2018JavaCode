/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5137.robot;

import org.usfirst.frc.team5137.commands.AutonoumousCommandGroup;
import org.usfirst.frc.team5137.subsystems.DriveBase;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

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
	/*	The Robot class acts as a kind of hub for all other classes, including subsystems and commands. 
	 * For example, by stating that the DriveBase is static and public, 
	 * it allows the whole robot program to find it.  With out doing this, no class could find another.
	 */
	
	public static Timer timer = new Timer(); 
	/* This creates a timer that the whole Robot can see and can be used to run commands off of
	 i.e. the AutoDrive command does.
	*/
	
	Command autonomousCommand; 
	// This tells the Robot that there is an autonomousCommand 
	 

	public void robotInit() {
		
		/*	robotInit() is the first thing the robot does on boot up
		 it is used to declare what subsytems and the oi are and to calibrate any gyros 
		 and start timers
		 */
		RobotMap.init();
	   	RobotMap.gyro.calibrate();
	   	/*
	   	 The above 2 lines are required if the gyro is being used by any system,
	   	 If it is not in place, the gyro is basically never turned on or accessed.
	   	 */
	   	 
	   	driveBase = new DriveBase();
		oi = new OI();
		autonomousCommand = new AutonoumousCommandGroup(); // declares what the autonomous period will run for its command!
		// Declaring that the driveBase, or any subsystem including the oi
		//is a new subsystem is required during the init process or they won't work
		timer.reset();
		timer.start();
		
	}
	
	public static void resetTimer() {
		timer.reset();
	}
	
	public void autonomousInit() {
		if (autonomousCommand != null) autonomousCommand.start();
		timer.reset();
		timer.start();
		
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		//This runs the default command defined in robotInit()
		
	}

	    
	public void teleopInit() {
		if (autonomousCommand != null)
		autonomousCommand.cancel();
		   
	}
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//This runs any default commands defined in any subsystems, typically, only the driveBase/Train has one set
		
	}

	public void testPeriodic() {
	}
}
