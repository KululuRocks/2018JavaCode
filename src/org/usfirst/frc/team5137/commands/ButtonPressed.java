package org.usfirst.frc.team5137.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ButtonPressed extends Command {

	EncoderDriveForward edf;
	
	public ButtonPressed(EncoderDriveForward edf) {
		this.edf = edf;
	}
	
	public void execute() {
		this.edf.execute();
	}
	
	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
	}
	
}
