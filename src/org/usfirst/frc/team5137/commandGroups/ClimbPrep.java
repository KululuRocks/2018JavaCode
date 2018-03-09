package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.RaiseLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * Prepares the robot for climbing by lowering the intake system
 * and raising the lift to max height. To be activated by driver
 * with the press of a button when the 30 second alarm initiates.
 */
public class ClimbPrep extends CommandGroup {

	public ClimbPrep() {
		addParallel(new RaiseLift(6)); // can be excessively wrong
		addParallel(new LowerIntake(3)); // might be too long
	}
	
}
