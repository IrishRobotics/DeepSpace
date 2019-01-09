/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {

    private WPI_TalonSRX frontLeft;
    private VictorSPX backLeft;
    private WPI_TalonSRX frontRight;
    private VictorSPX backRight;
    private DifferentialDrive drive;

    public Drive() {
        super();
        frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MOTOR);
        backLeft = new VictorSPX(RobotMap.BACK_LEFT_MOTOR);
        backLeft.set(ControlMode.Follower, RobotMap.FRONT_LEFT_MOTOR);

        frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR);
        backRight = new VictorSPX(RobotMap.BACK_RIGHT_MOTOR);
        backRight.set(ControlMode.Follower, RobotMap.FRONT_RIGHT_MOTOR);

        drive = new DifferentialDrive(frontLeft, frontRight);

        //leftEncoder = RobotMap.LEFT_ENCODER;
        //rightEncoder = RobotMap.RIGHT_ENCODER;
        //leftEncoder.setDistancePerPulse((0.5 * Math.PI) / 360.0);
        //rightEncoder.setDistancePerPulse((0.5 * Math.PI) / 360.0);
    }

    /**
     * When no other command is running let the operator drive around using the
     * PS3 joystick.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    public void move(double left, double right) {
        drive.tankDrive(left, right);
    }
}