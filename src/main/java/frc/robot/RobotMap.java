/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  
  public static final int FRONT_RIGHT_MOTOR = 0;
  public static final int BACK_RIGHT_MOTOR = 1;
  public static final int FRONT_LEFT_MOTOR = 2;
  public static final int BACK_LEFT_MOTOR = 3;

  public static final int LEFT_ACTUATOR = 4;
  public final static int RIGHT_ACTUATOR = 5;

  public static final int XBOX_CONTROLLER = 0;
  
  //number of auto && tele modes
  public static final int AUTO_MODES = 2;
  public static final int SANDSTORM_TELE_MODES = 0;
  public static final int TELE_MODES = 2;
}
