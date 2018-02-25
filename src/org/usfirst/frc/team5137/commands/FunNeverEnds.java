package org.usfirst.frc.team5137.commands;

import edu.wpi.first.wpilibj.command.Command;

/*
 * Empty command to put at the end of a CommandGroup so it never officially ends.
 */
public class FunNeverEnds extends Command {

	public FunNeverEnds() { 
		
	}

	protected void execute() {
		
	}

	protected void interrupted() {
		end();
	}
	
	protected void end() {

	}

	protected boolean isFinished() {
		return false;
	}
	
}
