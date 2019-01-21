/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2606.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2606.robot.Robot;

/**
 * An example command. You can replace me with your own command.
 */
public class TankDrive extends Command {
  public TankDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    int direction;
    if (Robot.oi.rightTrigger < -.75) {
      Robot.drive.move(Robot.oi.leftStickY, Robot.oi.rightStickY);
      direction = 1;
      // SmartDashboard.putNumber("Reverse", Robot.oi.getRightTriggerValue());
    } else {
      direction = -1;
      // SmartDashboard.putNumber("straight", Robot.oi.getRightTriggerValue()*
      // direction);
    }
    Robot.drive.move(Robot.oi.leftStickY * direction, Robot.oi.rightStickY * direction);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive.move(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}