package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DriveForwardWithEncoder;
import org.usfirst.frc.team5137.commands.DriveSidewaysWithEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderAuto extends CommandGroup {

	public EncoderAuto() {
		addSequential(new DriveForwardWithEncoder(100));
		addSequential(new DriveSidewaysWithEncoder(50));
		addSequential(new DriveForwardWithEncoder(50));
	}
	
}
