package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.DriveForward;
import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.Outtake;
import org.usfirst.frc.team5137.commands.RaiseLift;
import org.usfirst.frc.team5137.commands.EncoderDriveForward;
import org.usfirst.frc.team5137.commands.EncoderPivot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * Autonomous routine in which the robot starts from the center of the field,
 * drives forward 7 feet, drives sideways (direction determined by gameData) 
 * 5 feet, then drives forward the final 4 feet and outtakes the power cube
 * onto the switch.
 */
public class CenterAutoSwitch extends CommandGroup implements RequiresGameData {

	private DisplayValues displayValues;
	private LowerIntake lowerIntake;
	private RaiseLift raiseLift;
	private EncoderDriveForward driveForward1;
	private EncoderPivot pivot1;
	private EncoderDriveForward driveForward2;
	private EncoderPivot pivot2;
	private DriveForward driveForward3;
	private Outtake outtake;

	public CenterAutoSwitch() {
		displayValues = new DisplayValues();
		lowerIntake = new LowerIntake();
		raiseLift = new RaiseLift();
		driveForward1 = new EncoderDriveForward(2 * 12, .65); // 2 feet
		pivot1 = new EncoderPivot(2 * 12, .65); // about 90 degrees
		driveForward2 = new EncoderDriveForward(3.5 * 12, .65); // 3.5 feet (lateral)
		pivot2 = new EncoderPivot(2 * 12, .65); // pivot back (direction set below)
		driveForward3 = new DriveForward(.65); // rest of the forward distance
		outtake = new Outtake();
		
		addParallel(displayValues);
		addSequential(lowerIntake, 1);
		addSequential(raiseLift, 1.2);
		addSequential(driveForward1);
		addSequential(pivot1);
		addSequential(driveForward2);
		addSequential(pivot2);
		addSequential(driveForward3, 2.5);
		addSequential(outtake, 1);
	}
	
	// sets the direction of the pivots
	public void setGameData(String gameData) {
		if (gameData.length() > 0) {
		    if (gameData.charAt(0) == 'L') {
		    	pivot1.setDirection(true);
		    	pivot2.setDirection(false);
		    } else {
		    	pivot1.setDirection(false);
		    	pivot2.setDirection(true);
		    }
		} else {
			pivot1.setDirection(true);
	    	pivot2.setDirection(false);
		}
	}
	
}