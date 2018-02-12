package org.usfirst.frc.team5137.robot;

import org.usfirst.frc.team5137.commands.ArcadeDrive;
import org.usfirst.frc.team5137.commands.DisplayValues;
import org.usfirst.frc.team5137.commands.DriveStraight;
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
	
	public JoystickButton arcadeModeBumper;
	public JoystickButton tankModeBumper;
	public JoystickButton DriveStraightButton;
	public JoystickButton resetGyro;
	public JoystickButton displayValuesButtons;
	
	public OI() {
		jackBlack = new Joystick(0);
		
		arcadeModeBumper = new JoystickButton(jackBlack, 6);
		arcadeModeBumper.toggleWhenPressed(new ArcadeDrive());
		
		tankModeBumper = new JoystickButton(jackBlack, 5);
		tankModeBumper.toggleWhenPressed(new TankDrive());
		
		DriveStraightButton = new JoystickButton(jackBlack,1);
		DriveStraightButton.whileHeld(new DriveStraight());
		
		resetGyro = new JoystickButton(jackBlack, 7);
		resetGyro.whileHeld(new ResetGyro());
		
		displayValuesButtons = new JoystickButton(jackBlack,9); // L_Stick in
		displayValuesButtons.toggleWhenPressed(new DisplayValues());
		
	}
}
