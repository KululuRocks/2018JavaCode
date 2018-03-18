package org.usfirst.frc.team5137.commands;


import org.usfirst.frc.team5137.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

    public class VisionDrive extends Command{
        
    boolean run = true;
        
    public VisionDrive () {
    requires(Robot.driveBase);
    }

    protected void execute() {
        Robot.driveBase.visionDrive();
    }
    
    protected void interrupted() {
        end();
    }
    
    protected void end() {
        Robot.driveBase.stop();
    }
   
    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
         run = true;
         return false;
    }
    
   
    
}