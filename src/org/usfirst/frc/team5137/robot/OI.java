package org.usfirst.frc.team5137.robot;

import org.usfirst.frc.team5137.commands.ArcadeDrive;
import org.usfirst.frc.team5137.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	public Joystick jackBlack;
	
	public JoystickButton arcadeModeBumper;
	public JoystickButton tankModeBumper;
	
	public OI() {
		jackBlack = new Joystick(0);
		
		arcadeModeBumper = new JoystickButton(jackBlack, 6);
		arcadeModeBumper.toggleWhenPressed(new ArcadeDrive());
		
		tankModeBumper = new JoystickButton(jackBlack, 5);
		tankModeBumper.toggleWhenPressed(new TankDrive());
	}
}
