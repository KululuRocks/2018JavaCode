package org.usfirst.frc.team5137.robot;

import org.usfirst.frc.team5137.commands.ArcadeDrive;
import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.DriveStraight;
import org.usfirst.frc.team5137.commands.IntakeVerb;
import org.usfirst.frc.team5137.commands.LowerIntake;
import org.usfirst.frc.team5137.commands.LowerLift;
import org.usfirst.frc.team5137.commands.Outtake;
import org.usfirst.frc.team5137.commands.RaiseIntake;
import org.usfirst.frc.team5137.commands.RaiseLift;
import org.usfirst.frc.team5137.commands.ResetGyro;
import org.usfirst.frc.team5137.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/*	The OI class is where all controllers are listed
 * It also functions to assign buttons and toggles 
 */
// the Joysticks and JoystickButtons must be labeled public so other systems can access them.
public class OI {

	public Joystick jackBlack;
	
	public JoystickButton raiseLiftButton;
	public JoystickButton lowerLiftButton;
	public JoystickButton raiseIntakeButton;
	public JoystickButton lowerIntakeButton;
	public JoystickButton intakeButton;
	public JoystickButton outtakeButton;
	
	/*
	public JoystickButton arcadeModeBumper;
	public JoystickButton tankModeBumper;
	public JoystickButton DriveStraightButton;
	public JoystickButton resetGyro;
	public JoystickButton displayValuesButtons; */
	public OI() {
		jackBlack = new Joystick(0);
		
		raiseLiftButton = new JoystickButton(jackBlack, 13); // up
		raiseLiftButton.whileHeld(new RaiseLift());
		
		lowerLiftButton = new JoystickButton(jackBlack, 14); // down
		lowerLiftButton.whileHeld(new LowerLift());
		
		raiseIntakeButton = new JoystickButton(jackBlack, 3); // X
		raiseIntakeButton.whileHeld(new RaiseIntake());
		
		lowerIntakeButton = new JoystickButton(jackBlack, 4); // Y
		lowerIntakeButton.whileHeld(new LowerIntake());
		
		intakeButton = new JoystickButton(jackBlack, 1); // A
		intakeButton.whileHeld(new IntakeVerb());
		
		outtakeButton = new JoystickButton(jackBlack, 2); // B
		outtakeButton.whileHeld(new Outtake());
		
		// toggle drive mode code. unnecessary bc tank drive is trash
		/*
		arcadeModeBumper = new JoystickButton(jackBlack, 6);
		arcadeModeBumper.toggleWhenPressed(new ArcadeDrive());
		
		tankModeBumper = new JoystickButton(jackBlack, 5);
		tankModeBumper.toggleWhenPressed(new TankDrive()); */
		
		// to see if DriveStraight works
		/*
		DriveStraightButton = new JoystickButton(jackBlack, 1); // A button
		DriveStraightButton.whileHeld(new DriveStraight()); */
		
		/*
		resetGyro = new JoystickButton(jackBlack, 7); // Left back thingy
		resetGyro.whileHeld(new ResetGyro()); */
		
		/*
		displayValuesButtons = new JoystickButton(jackBlack, 9); // L_Stick in
		displayValuesButtons.toggleWhenPressed(new DisplayValues());	*/
	}
}
