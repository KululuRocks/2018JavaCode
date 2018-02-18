package org.usfirst.frc.team5137.commandGroups;

import org.usfirst.frc.team5137.commands.DriveForwardWithEncoder;
import org.usfirst.frc.team5137.commands.DriveSidewaysWithEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderAuto extends CommandGroup implements RequiresGameData {

	private DriveForwardWithEncoder driveForward1;
	private DriveSidewaysWithEncoder driveSideways;
	private DriveForwardWithEncoder driveForward2;
	
	public EncoderAuto() {
		driveForward1 = new DriveForwardWithEncoder(100);
		driveSideways = new DriveSidewaysWithEncoder(50);
		driveForward2 = new DriveForwardWithEncoder(50);
		
		addSequential(driveForward1);
		addSequential(driveSideways);
		addSequential(driveForward2);
	}
	
	public void setGameData(String gameData) {
		driveSideways.setGameData(gameData);
	}
	
}
