/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5137.robot;
import org.usfirst.frc.team5137.commands.EncoderDriveForward;
import org.usfirst.frc.team5137.commandGroups.EncoderCenterAutoSwitch;
import org.usfirst.frc.team5137.commandGroups.EncoderLeftAutoSwitch;
import org.usfirst.frc.team5137.commandGroups.EncoderRightAutoSwitch;
import org.usfirst.frc.team5137.commandGroups.RequiresGameData;
import org.usfirst.frc.team5137.subsystems.DriveBase;
import org.usfirst.frc.team5137.subsystems.IntakeNoun;
import org.usfirst.frc.team5137.subsystems.Lift;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

/*	The Robot class acts as a kind of hub for all other classes, including subsystems and commands. 
 * For example, by stating that the DriveBase is static and public, 
 * it allows the whole robot program to find it.  With out doing this, no class could find another.
 */

public class Robot extends TimedRobot {
	
	public static DriveBase driveBase; 
	public static Lift lift;
	public static IntakeNoun intakeNoun;

	public static OI oi;	
	
	public static UsbCamera camera;
	public static Timer timer; 
	
	public static String gameData;
	public static boolean done = false;
	
	Command autonomousCommand; 
	SendableChooser<Command> autoChooser;
	
	/*	
	 * robotInit() is the first thing the robot does on boot up
	 * it is used to declare what subsystems and the OI are and to calibrate any gyros 
	 * and start timers
	 */
	public void robotInit() {
		RobotMap.init();
	   	RobotMap.gyro.calibrate(); // you need this if you're using the gyro
	   	 
	   	driveBase = new DriveBase();
	   	lift = new Lift();
	   	intakeNoun = new IntakeNoun();
	   	
		oi = new OI(); // gotta go after all the subsystems!
		
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(320, 240);
		camera.setFPS(30);
		timer = new Timer();
		
		// adds autonomous options and displays them on the SmartDashboard
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Cross the auto line", new EncoderDriveForward(11 * 12, .65));
		autoChooser.addObject("Switch from center", new EncoderCenterAutoSwitch());
		autoChooser.addObject("Switch from left", new EncoderLeftAutoSwitch());
		autoChooser.addObject("Switch from right", new EncoderRightAutoSwitch());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);		
	}
	
	/*
	 * The below code instructs the robot what to do when Autonomous mode is first pressed
	 * in this case, it tells it to run the autonomous default command and to reset and start the timer
	 */
	public void autonomousInit() {
		timer.reset(); // I feel like this is redundant
		timer.start(); // but idk for sure so I'm just gonna leave it.
		int retries = 100;
		//gameData = DriverStation.getInstance().getGameSpecificMessage();
		gameData = "LLR"; // For testing purposes.
		while (gameData.length() < 2 && retries > 0) {
		    retries--;
		    try {
		        Thread.sleep(5);
		    } catch (InterruptedException ie) {
		        // Just ignore the interrupted exception
		    }
		    gameData = DriverStation.getInstance().getGameSpecificMessage();
		}
		SmartDashboard.putString("gameData", gameData);
		autonomousCommand = (Command) autoChooser.getSelected();
		if (autonomousCommand instanceof RequiresGameData)
		{
			((RequiresGameData)autonomousCommand).setGameData(gameData);
		}
		autonomousCommand.start();
		timer.reset();
		timer.start();		
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		/*
		if (done) {
			autonomousCommand = new TestTimerLeftAuto();
			autonomousCommand.start();
			done = false;
		} 
		*/
	}
	
	// You have to tell the robot to stop doing autonomous stuff
	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
	}
	
	/* teleopPeriodic runs any default commands defined in any subsystems, 
	 * typically, only the driveBase has one set
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();		
	}

}
