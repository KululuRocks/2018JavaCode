package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.EncoderDriveSideways;
import org.usfirst.frc.team5137.commands.EncoderDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderCenterAutoSwitch extends CommandGroup implements RequiresGameData {

	private DisplayValues displayValues;
	private EncoderDriveForward driveForward1;
	private EncoderDriveSideways driveSideways;
	private EncoderDriveForward driveForward2;
	
	public EncoderCenterAutoSwitch() {
		displayValues = new DisplayValues();
		driveForward1 = new EncoderDriveForward(100, .65);
		driveSideways = new EncoderDriveSideways(50, .65); // speed should be from 0 to 1 bc gameData determines direction
		driveForward2 = new EncoderDriveForward(50, .65);
		
		addParallel(displayValues);
		addSequential(driveForward1);
		addSequential(driveSideways);
		addSequential(driveForward2);
	}
	
	public void setGameData(String gameData) {
		if (gameData.length() > 0) {
		    if (gameData.charAt(0) == 'L') driveSideways.setDriveDirection(true);
		    else driveSideways.setDriveDirection(false);
		}
	}
	
}
