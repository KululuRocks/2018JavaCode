package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.DriveForwardWithTimer;
import org.usfirst.frc.team5137.commands.DriveSidewaysWithTimer;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimerAutoLeft extends CommandGroup {

	public TimerAutoLeft() {
		addParallel(new DisplayValues());
		addSequential(new DriveForwardWithTimer(2, false));
		addSequential(new DriveSidewaysWithTimer(2, -1 ));
		addSequential(new DriveForwardWithTimer(2, true));
	}
}
