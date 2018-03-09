package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.Outtake;
import org.usfirst.frc.team5137.commands.RaiseLift;
import org.usfirst.frc.team5137.commands.TimerDriveForward;
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
	private TimerDriveForward driveForward2; // bc all the encoders are being bitches
	private Outtake outtake;
	
	public EncoderCenterAutoSwitch() {
		displayValues = new DisplayValues();
		lowerIntake = new LowerIntake(1);
		raiseLift = new RaiseLift(1);
		driveForward1 = new EncoderDriveForward(5 * 12, .65); // 5 feet
		driveSideways = new TimerDriveSideways(2, .75); // speed should be from 0 to 1 bc gameData determines direction
		driveForward2 = new TimerDriveForward(3, .65); // who knows?
		outtake = new Outtake(1);
		
		addParallel(displayValues);
		addSequential(lowerIntake);
		addSequential(raiseLift);
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
