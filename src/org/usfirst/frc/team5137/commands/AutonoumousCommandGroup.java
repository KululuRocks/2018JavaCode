package org.usfirst.frc.team5137.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonoumousCommandGroup extends CommandGroup {
	
	public void AutonomousCommandGroup() {
	
		System.out.println("HIIIIIIIII");
		//addSequential(new DriveStraight());
		//addSequential(new DisplayValues());
		addSequential(new DriveStraight());
		
		
	}
		
}
