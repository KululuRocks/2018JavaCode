package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.LowerLift;
import org.usfirst.frc.team5137.commands.RaiseLift;
import org.usfirst.frc.team5137.commands.TimerDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Climb extends CommandGroup {

	public Climb() {
		addSequential(new TimerDriveForward(1, -.65));
		addParallel(new LowerIntake(2));
		addParallel(new RaiseLift(2));
		addSequential(new TimerDriveForward(1, .65));
		addSequential(new LowerLift(2));
	}
	
}
