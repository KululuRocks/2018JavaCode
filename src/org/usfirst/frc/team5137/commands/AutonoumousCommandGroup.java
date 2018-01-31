package org.usfirst.frc.team5137.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
// Command groups are used to run multiple commands at once, in sequence or a combination of both
public class AutonoumousCommandGroup extends CommandGroup {
	
	public AutonoumousCommandGroup() {
	
		System.out.println("HIIIIIIIII"); // This is a check to see if the autonomous periodic is actually running
		addSequential(new DriveStraight());// This is the command it will run first
		addParallel(new DisplayValues());	// The command it will run in parallel to the one above
		
	}
		
}
