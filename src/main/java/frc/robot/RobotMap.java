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

  // TallonSRX CAN Addresses
  public static final int FRONT_RIGHT_MOTOR = 0;
  public static final int BACK_RIGHT_MOTOR = 0;
  // VictorSPX CAN Addresses
  public static final int FRONT_LEFT_MOTOR = 1;
  public static final int BACK_LEFT_MOTOR = 1;

  // PWM Motors/Actuators
  public static final int LEFT_INTAKE_MOTOR = 1;
  public static final int RIGHT_INTAKE_MOTOR = 2;

  public static final int LEFT_ACTUATOR = 3;
  public static final int RIGHT_ACTUATOR = 4;

  // Pneumatics
  public static final int COMPRESSOR = 0;
  public static final int HATCH_SOLINOID_1 = 1;
  public static final int HATCH_SOLINOID_2 = 2;
  public static final int HATCH_SOLINOID_3 = 3;
  public static final int LIFT_SOLINOID_1 = 4;
  public static final int LIFT_SOLINOID_2 = 5;
  public static final int LIFT_SOLINOID_3 = 6;
  public static final int LIFT_SOLINOID_4 = 7;

  //PID
  public static final int PID_P = 0;
  public static final int PID_I = 0;
  public static final int PID_D = 0;

  //Goal Heights (in inches to center)
  public static final double HATCH_TAPE = 25.5;
  public static final int HATCH_BOTTOM = 19;
  public static final int HATCH_MIDDLE = 47;
  public static final int HATCH_TOP = 75;
  public static final double PORT_TAPE = 34;
  public static final double PORT_BOTTOM = 27.5;
  public static final double PORT_MIDDLE = 55.5;
  public static final double PORT_TOP = 83.5;
  public static final double PORT_SHIP = 39.75;

  // Misc.
  public static final int XBOX_CONTROLLER = 0;
  public static final int PICTURE_WIDTH = 640;
  public static final int PICTURE_HEIGHT = 480;
  public static final double FOV_X = 62;
  public static final double FOV_Y = 34;
  public static final double CAMERA_HEIGHT = 5;

  // number of auto && tele modes
  public static final int AUTO_MODES = 2;
  public static final int SANDSTORM_TELE_MODES = 0;
  public static final int TELE_MODES = 2;
}
