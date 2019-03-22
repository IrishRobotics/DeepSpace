/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2606.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public static XboxController xboxController = new XboxController(RobotMap.XBOX_CONTROLLER);

  public static boolean xboxA = xboxController.getAButton();
  public static boolean xboxB = xboxController.getBButton();
  public static boolean xboxX = xboxController.getXButton();
  public static boolean xboxY = xboxController.getYButton();

  public static boolean back = xboxController.getBackButton();
  public static boolean start = xboxController.getStartButton();

  public static boolean leftBumper = xboxController.getBumper(Hand.kLeft);
  public static boolean rightBumper = xboxController.getBumper(Hand.kRight);

  public static boolean leftStick = xboxController.getStickButton(Hand.kLeft);
  public static boolean rightStick = xboxController.getStickButton(Hand.kRight);

  public static double leftTrigger = xboxController.getTriggerAxis(Hand.kLeft);
  public static double rightTrigger = xboxController.getTriggerAxis(Hand.kRight);

  public static double leftStickX = xboxController.getX(Hand.kLeft);
  public static double leftStickY = xboxController.getY(Hand.kLeft);
  public static double rightStickX = xboxController.getX(Hand.kRight);
  public static double rightStickY = xboxController.getY(Hand.kRight);

  public static double getRightThrottle() {
    //return rightStickY;
    return xboxController.getY(Hand.kRight);
  }

  public static double getLeftThrottle() {
    //return leftStickY;
    return xboxController.getY(Hand.kLeft);
  }

}
