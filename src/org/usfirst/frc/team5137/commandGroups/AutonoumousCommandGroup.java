package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.AutoDrive;
import org.usfirst.frc.team5137.commands.DisplayValues;

import edu.wpi.first.wpilibj.command.CommandGroup;
// Command groups are used to run multiple commands at once, in sequence, or a combination of both
public class AutonoumousCommandGroup extends CommandGroup {
	
	public AutonoumousCommandGroup() {
		addSequential(new AutoDrive());		// This is the command it will run first
		addParallel(new DisplayValues());	// The command it will run in parallel to the one above	
	}
		
}
