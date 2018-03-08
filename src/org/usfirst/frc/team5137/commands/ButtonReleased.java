package org.usfirst.frc.team5137.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ButtonReleased extends Command {
	
	EncoderDriveForward edf;
	
	public ButtonReleased(EncoderDriveForward edf) {
		this.edf = edf;
	}
	
	public void execute() {
		this.edf.resetEncoder();
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
