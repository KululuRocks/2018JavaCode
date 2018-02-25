package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.EncoderDriveForward;
import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.Outtake;
import org.usfirst.frc.team5137.commands.RaiseLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * Autonomous routine in which the robot starts from the left side of the field,
 * drives forward across the auto line, and outtakes only if the left switch is ours.
 */
public class EncoderLeftAutoSwitch extends CommandGroup implements RequiresGameData {

	private DisplayValues displayValues;
	private LowerIntake lowerIntake;
	private RaiseLift raiseLift;
	private EncoderDriveForward driveForward;
	private Outtake outtake;
	
	public EncoderLeftAutoSwitch() {
		displayValues = new DisplayValues();
		lowerIntake = new LowerIntake(2);
		raiseLift = new RaiseLift(2);
		driveForward = new EncoderDriveForward(11 * 12, .65); // 11 feet
		outtake = new Outtake(2);
		
		addParallel(displayValues);
		addParallel(lowerIntake);
		addParallel(raiseLift);
     	addSequential(driveForward); 
     	addSequential(outtake);
	}
	
	// tells outtake whether or not to run
	public void setGameData(String gameData) {
		if (gameData.length() > 0) {
		    if (gameData.charAt(0) == 'L') outtake.setWillRun(true);
		    else outtake.setWillRun(false);
		}
	}
}
