package org.usfirst.frc.team5137.subsystems;

import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeNoun extends Subsystem {

	Spark rotateIntakeMotor = RobotMap.rotateIntakeMotor;
	Spark intakeMotor = RobotMap.intakeMotor;
	
	public void raiseIntake() {
		rotateIntakeMotor.set(.65);
	}
	
	public void lowerIntake() {
		rotateIntakeMotor.set(-.5);
	}
	
	public void intake() {
		intakeMotor.set(-.6);
	}
	
	public void outtake() {
		intakeMotor.set(.7);
	}
	
	public void stop() {
		rotateIntakeMotor.set(0);
		intakeMotor.set(0);
	}
	
	protected void initDefaultCommand() {
		
	}

}
