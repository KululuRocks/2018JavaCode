package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.Outtake;
import org.usfirst.frc.team5137.commands.RaiseLift;
import org.usfirst.frc.team5137.commands.TimerDriveSideways;
import org.usfirst.frc.team5137.commands.EncoderDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * Autonomous routine in which the robot starts from the center of the field,
 * drives forward 7 feet, drives sideways (direction determined by gameData) 
 * 5 feet, then drives forward the final 4 feet and outtakes the power cube
 * onto the switch.
 */
public class EncoderCenterAutoSwitch extends CommandGroup implements RequiresGameData {

	private DisplayValues displayValues;
	private LowerIntake lowerIntake;
	private RaiseLift raiseLift;
	private EncoderDriveForward driveForward1;
	private TimerDriveSideways driveSideways; // bc EncoderDriveSideways is being a bitch
	private EncoderDriveForward driveForward2;
	private Outtake outtake;
	
	public EncoderCenterAutoSwitch() {
		displayValues = new DisplayValues();
		lowerIntake = new LowerIntake(2);
		raiseLift = new RaiseLift(2);
		driveForward1 = new EncoderDriveForward(7 * 12, .65); // 7 feet
		driveSideways = new TimerDriveSideways(4, .65); // speed should be from 0 to 1 bc gameData determines direction
		driveForward2 = new EncoderDriveForward(4 * 12, .65); // 4 feet
		outtake = new Outtake(2);
		
		addParallel(displayValues);
		addParallel(lowerIntake);
		addParallel(raiseLift);
		addSequential(driveForward1);
		addSequential(driveSideways);
		addSequential(driveForward2);
		addSequential(outtake);
	}
	
	// tells driveSideways which way to go
	public void setGameData(String gameData) {
		if (gameData.length() > 0) {
		    if (gameData.charAt(0) == 'L') driveSideways.setDriveDirection(true);
		    else driveSideways.setDriveDirection(false);
		} else driveSideways.setDriveDirection(false);
	}
	
}
