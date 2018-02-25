package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.Bookend;
import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.TimerDriveForward;
import org.usfirst.frc.team5137.commands.TimerDriveSideways;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * Test autonomous routine to see if the timer driving code works.
 */
public class TestTimerLeftAuto extends CommandGroup {

	public TestTimerLeftAuto() {
		addParallel(new DisplayValues());
		addSequential(new TimerDriveForward(2, .65));
		addSequential(new TimerDriveSideways(2, -1 ));
		addSequential(new TimerDriveForward(2, .65));
		addSequential(new Bookend());
	}
	
}
