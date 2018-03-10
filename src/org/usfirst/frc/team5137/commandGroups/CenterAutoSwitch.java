package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.Outtake;
import org.usfirst.frc.team5137.commands.Pivot;
import org.usfirst.frc.team5137.commands.RaiseLift;
import org.usfirst.frc.team5137.commands.TimerDriveForward;
import org.usfirst.frc.team5137.commands.EncoderDriveForward;
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
	private Pivot pivot1;
	private EncoderDriveForward driveForward2;
	private Pivot pivot2;
	private TimerDriveForward driveForward3; // bc all the encoders are being bitches
	private Outtake outtake;

	public CenterAutoSwitch() {
		displayValues = new DisplayValues();
		lowerIntake = new LowerIntake(1);
		raiseLift = new RaiseLift(1.5);
		driveForward1 = new EncoderDriveForward(5 * 12, .65); // 5 feet
		pivot1 = new Pivot(1, .6);
		driveForward2 = new EncoderDriveForward(3 * 12, .5);
		pivot2 = new Pivot(1, -.6);
		driveForward3 = new TimerDriveForward(4, .65);
		outtake = new Outtake(1);
		
		addParallel(displayValues);
		addSequential(lowerIntake);
		addSequential(raiseLift);
		addSequential(driveForward1);
		addSequential(pivot1);
		addSequential(driveForward2);
		addSequential(pivot2);
		addSequential(driveForward3);
		addSequential(outtake);
	}
	
	// tells driveSideways which way to go
	public void setGameData(String gameData) {
		if (gameData.length() > 0) {
		    if (gameData.charAt(0) == 'L') {
		    	pivot1.setPivotDirection(true);
		    	pivot2.setPivotDirection(true);
		    } else {
		    	pivot1.setPivotDirection(false);
		    	pivot2.setPivotDirection(false);
		    }
		} else {
			pivot1.setPivotDirection(false);
	    	pivot2.setPivotDirection(false);
		}
	}
	
}
