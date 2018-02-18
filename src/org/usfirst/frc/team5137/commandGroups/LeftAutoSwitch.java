package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DriveForwardWithEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAutoSwitch extends CommandGroup {

	public LeftAutoSwitch() {
		addSequential(new DriveForwardWithEncoder(100)); //ARBITRARY fix those encoders
	}
}
