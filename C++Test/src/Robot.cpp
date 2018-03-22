/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

#include "Robot.h"
#include <WPILib.h>

#include <Commands/Scheduler.h>
#include <SmartDashboard/SmartDashboard.h>
//#define MotorController	Victor
//#define MotorController	Talon
//#define MotorController	Jaguar
#define MotorController	Spark


ExampleSubsystem Robot::m_subsystem;
OI Robot::m_oi;

double autoWaitTime;
double autoDriveTime;

DifferentialDrive *drive;

void Robot::RobotInit() {
	m_chooser.AddDefault("Default Auto", &m_defaultAuto);
	m_chooser.AddObject("My Auto", &m_myAuto);
	frc::SmartDashboard::PutData("Auto Modes", &m_chooser);

}

/**
 * This function is called once each time the robot enters Disabled mode. You
 * can use it to reset any subsystem information you want to clear when the
 * robot is disabled.
 */
void Robot::DisabledInit() {}

void Robot::DisabledPeriodic() {
	frc::Scheduler::GetInstance()->Run();
}

/**
 * This autonomous (along with the chooser code above) shows how to select
 * between different autonomous modes using the dashboard. The sendable chooser
 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
 * remove all of the chooser code and uncomment the GetString code to get the
 * auto name from the text box below the Gyro.
 *
 * You can add additional auto modes by adding additional commands to the
 * chooser code above (like the commented example) or additional comparisons to
 * the if-else structure below with additional strings & commands.
 */
void Robot::AutonomousInit() {
	// std::string autoSelected = frc::SmartDashboard::GetString(
	// 		"Auto Selector", "Default");
	// if (autoSelected == "My Auto") {
	// 	m_autonomousCommand = &m_myAuto;
	// } else {
	// 	m_autonomousCommand = &m_defaultAuto;
	// }

		SpeedController *leftMaster = new MotorController(0);
		SpeedController *leftSlave = new MotorController(1); // Comment (ctl + /) this line if using PWM Y-Wire, or only using 1 motor on left side

		SpeedControllerGroup *leftGearbox	= new SpeedControllerGroup(*leftMaster, *leftSlave);
		SpeedController *rightMaster = new MotorController(2);
		SpeedController *rightSlave = new MotorController(3); // See above
		SpeedControllerGroup *rightGearbox = new SpeedControllerGroup(*rightMaster,*rightSlave);
		drive = new DifferentialDrive(*leftGearbox, *rightGearbox);

		frc::SmartDashboard::SetDefaultNumber("Wait Timer", 0);
		autoWaitTime = frc::SmartDashboard::GetNumber("Wait Timer", 0); // Gets how long to wait before moving forwards, drivers must type this in when setting up the match
		autoDriveTime = 2;  // TODO: See if this drives where you need it to be

	m_autonomousCommand = m_chooser.GetSelected();

	if (m_autonomousCommand != nullptr) {
		m_autonomousCommand->Start();
	}



}

void Robot::AutonomousPeriodic() {
	//frc::Scheduler::GetInstance()->Run();

	double timeElapsed = 15 - frc::DriverStation::GetInstance().GetMatchTime(); // The DriverStation gives an approximate time until the end of the period

			if (timeElapsed >= autoWaitTime) {
				if (timeElapsed <= autoWaitTime + autoDriveTime) {
					drive->TankDrive(0.2, 0.2); // Left and Right speeds, 20% power
				}
			}
}

void Robot::TeleopInit() {
	// This makes sure that the autonomous stops running when
	// teleop starts running. If you want the autonomous to
	// continue until interrupted by another command, remove
	// this line or comment it out.
	if (m_autonomousCommand != nullptr) {
		m_autonomousCommand->Cancel();
		m_autonomousCommand = nullptr;
	}
}

void Robot::TeleopPeriodic() {
	frc::Scheduler::GetInstance()->Run();
}

void Robot::TestPeriodic() {}

START_ROBOT_CLASS(Robot)
