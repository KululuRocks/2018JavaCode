package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.Outtake;
import org.usfirst.frc.team5137.commands.RaiseLift;
import org.usfirst.frc.team5137.commands.TimerDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * Autonomous routine in which the robot starts from the left side of the field,
 * drives forward across the auto line, and outtakes only if the left switch is ours.
 */
public class TimerLeftAutoSwitch extends CommandGroup implements RequiresGameData {

	private DisplayValues displayValues;
	private LowerIntake lowerIntake;
	private RaiseLift raiseLift;
	private TimerDriveForward driveForward;
	private Outtake outtake;
	
	public TimerLeftAutoSwitch() {
		displayValues = new DisplayValues();
		lowerIntake = new LowerIntake(1);
		raiseLift = new RaiseLift(1.5);
		driveForward = new TimerDriveForward(4, .65);
		outtake = new Outtake(1);
		
		addParallel(displayValues);
		addSequential(lowerIntake);
		addSequential(raiseLift);
     	addSequential(driveForward); 
     	addSequential(outtake);
	}
	
	// tells outtake whether or not to run
	public void setGameData(String gameData) {
		if (gameData.length() > 0) {
		    if (gameData.charAt(0) == 'L') outtake.setWillRun(true);
		    else outtake.setWillRun(false);
		} else outtake.setWillRun(false);
	}
}
