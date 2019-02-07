 /*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2606.robot;

/**
 * The FieldMap is a mapping for the dimensions of the field elements
 * and vision targets. It also includes dimensions of certain components
 * of the robot. These dimensions are all defined in one place to allow 
 * changes to be made easily and significantly reduces the number of magic
 * numbers floating around.
 */
public class FieldMap {
 
 //Goal Heights (in inches to center)
  public static final int HATCH_BOTTOM = 19;
  public static final int HATCH_MIDDLE = 47;
  public static final int HATCH_TOP = 75;
  public static final double PORT_BOTTOM = 27.5;
  public static final double PORT_MIDDLE = 55.5;
  public static final double PORT_TOP = 83.5;
  public static final double PORT_SHIP = 39.75;

  //Vision Targets
  public static final double TAPE_WIDTH = 14.62677061;
  public static final double TAPE_HEIGHT = 5.82557203;
  public static final double TAPE_CENTER_X = 7.313385305;
  public static final double TAPE_CENTER_Y = 2.912786015;
  public static final double HATCH_TAPE_TOP = 31.5;
  public static final double PORT_TAPE_TOP = 39.125;
  public static final double HATCH_TAPE_CENTER = HATCH_TAPE_TOP - TAPE_CENTER_Y;
  public static final double PORT_TAPE_CENTER = PORT_TAPE_TOP - TAPE_CENTER_Y;

  //Robot Dimensions
  public static final double ROBOT_LENGTH = 32.3;
  public static final double ROBOT_WIDTH = 27.5;
  public static final double BUMPER_THICKNESS = 3;
  public static final double ARM_SETBACK = 30;
  public static final double ARM_HEIGHT = 42;
  public static final double ARM_LENGTH = 50;
  public static final double INTAKE_WIDTH = 19;
  public static final double BALL_INTAKE_HEIGHT = 16;
  public static final double BALL_INTAKE_DEPTH = 14;
  public static final double BALL_INTAKE_OFFSET = -3;
  public static final double HATCH_INTAKE_HEIGHT = 10;
  public static final double HATCH_INTAKE_DEPTH = 6;
  public static final double HATCH_INTAKE_OFFSET = 6;
}