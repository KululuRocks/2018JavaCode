/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5137.robot;
import org.usfirst.frc.team5137.commandGroups.AutonoumousCommandGroup;
import org.usfirst.frc.team5137.commands.DriveStraight;
import org.usfirst.frc.team5137.commandGroups.EncoderAuto;
import org.usfirst.frc.team5137.subsystems.DriveBase;
import org.usfirst.frc.team5137.subsystems.IntakeNoun;
import org.usfirst.frc.team5137.subsystems.Lift;

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
	
	public static Timer timer; 
	/* This creates a timer that the whole Robot can see and can be used to run commands off of
	 i.e. the AutoDrive command does.
	*/
	
	public static String gameData;
	
	Command autonomousCommand; 
	SendableChooser<Command> autoChooser;
	
	/*	robotInit() is the first thing the robot does on boot up
	 it is used to declare what subsystems and the OI are and to calibrate any gyros 
	 and start timers
	*/
	public void robotInit() {
		RobotMap.init();
	   	RobotMap.gyro.calibrate(); // you need this if you're using the gyro
	   	 
	   	driveBase = new DriveBase();
	   	lift = new Lift();
	   	intakeNoun = new IntakeNoun();
	   	
		oi = new OI(); // gotta go after all the subsystems!
		timer = new Timer();
		
		// adds autonomous options and displays them on the SmartDashboard
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Default program", new AutonoumousCommandGroup());
		autoChooser.addObject("Drive Forever", new DriveStraight());
		autoChooser.addObject("Encoder auto", new EncoderAuto());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);		
	}
	
	public static void resetTimer() {
		timer.reset();
	}	
	
	/*The below code instructs the robot what to do when Autonomous mode is first pressed
	 in this case, it tells it to run the autonomous default command and to reset and start the timer
	*/
public void autonomousInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
		timer.reset();
		timer.start();		
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}
	
	// You have to tell the robot to stop doing autonomous stuff
	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
	}
	
	/* teleopPeriodic runs any default commands defined in any subsystems, 
	 * typically, only the driveBase/Train has one set
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();		
	}

}
