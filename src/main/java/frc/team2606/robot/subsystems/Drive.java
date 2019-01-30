/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2606.robot.subsystems;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team2606.lib.drivers.TalonSRXFactory;
import frc.team2606.lib.drivers.VictorSPXFactory;
import frc.team2606.lib.geometry.Pose2d;
import frc.team2606.lib.geometry.Pose2dWithCurvature;
import frc.team2606.lib.geometry.Rotation2d;
import frc.team2606.lib.trajectory.timing.TimedState;
import frc.team2606.robot.RobotMap;
import frc.team2606.robot.commands.TankDrive;
import frc.team2606.robot.loops.Loop;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {

    private static Drive driveInstance = new Drive();
    // Hardware
    private TalonSRX frontLeft, frontRight;
    private VictorSPX backLeft, backRight;
    private DifferentialDrive drive;
    // Control States
    private DriveControlState driveControlState;
    // Hardware States
    private PeriodicIO periodicIO;

    private final Loop loop = new Loop() {
        @Override
        public void onStart(double timestamp) {
            // synchronized (Drive.this) {
            // setOpenLoop(new DriveSignal(0.05, 0.05));
            // setBrakeMode(false);
            // startLogging();
            // }
        }

        @Override
        public void onLoop(double timestamp) {
            synchronized (Drive.this) {
                switch (driveControlState) {
                case OPEN_LOOP:
                    break;
                case PATH_FOLLOWING:
                    updatePathFollower();
                    break;
                default:
                    System.out.println("Unexpected drive control state: " + driveControlState);
                    break;
                }
            }
        }

        @Override
        public void onStop(double timestamp) {
            stop();
            // stopLogging();
        }
    };

    private void configureMaster(TalonSRX talon, boolean left) {
        talon.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 5, 100);
        final ErrorCode sensorPresent = talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
                100); // primary closed-loop, 100 ms timeout
        if (sensorPresent != ErrorCode.OK) {
            DriverStation.reportError("Could not detect " + (left ? "left" : "right") + " encoder: " + sensorPresent,
                    false);
        }
        talon.setInverted(!left);
        talon.setSensorPhase(true);
        talon.enableVoltageCompensation(true);
        talon.configVoltageCompSaturation(12.0, RobotMap.LONG_CAN_TIMEOUT);
        talon.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_50Ms, RobotMap.LONG_CAN_TIMEOUT);
        talon.configVelocityMeasurementWindow(1, RobotMap.LONG_CAN_TIMEOUT);
        talon.configClosedloopRamp(RobotMap.DRIVE_VOLTAGE_RAMP_RATE, RobotMap.LONG_CAN_TIMEOUT);
        talon.configNeutralDeadband(0.04, 0);
    }

    private Drive() {

        frontLeft = TalonSRXFactory.createDefaultTalon(RobotMap.FRONT_LEFT_MOTOR);
        configureMaster(frontLeft, true);

        backLeft = VictorSPXFactory.createPermanentSlaveVictor(RobotMap.BACK_LEFT_MOTOR, RobotMap.FRONT_LEFT_MOTOR);
        backLeft.setInverted(false);

        frontRight = TalonSRXFactory.createDefaultTalon(RobotMap.FRONT_RIGHT_MOTOR);
        configureMaster(frontRight, false);

        backRight = VictorSPXFactory.createPermanentSlaveVictor(RobotMap.BACK_RIGHT_MOTOR, RobotMap.FRONT_RIGHT_MOTOR);
        backRight.setInverted(true);

    }

    public static Drive getInstance() {
        return driveInstance;
    }

    public Rotation2d getHeading() {
        return null;
    }

    public synchronized void resetEncoders() {
        frontLeft.setSelectedSensorPosition(0, 0, 0);
        frontRight.setSelectedSensorPosition(0, 0, 0);
        periodicIO = new PeriodicIO();
    }

    public double getLeftEncoderRotations() {
        return 0;
    }

    public double getRightEncoderRotations() {
        return 0;
    }

    public double getLeftEncoderDistance() {
        return 0;
    }

    public double getRightEncoderDistance() {
        return 0;
    }

    public double getLeftVelocicyNativeUnits() {
        return 0;
    }

    public double getRightVelocityNativeUnits() {
        return 0;
    }

    public double getLeftLinearVelocity() {
        return 0;
    }

    public double getRightLinearVelocity() {
        return 0;
    }

    private void updatePathFollower() {

    }

    public void setHeading(Rotation2d rotation) {
    }

    @Override
    public boolean checkSystem() {
        return false;
    }

    @Override
    public void outputTelemetry() {

    }

    @Override
    public void stop() {

    }

    // The robot drivetrain's various states.
    public enum DriveControlState {
        OPEN_LOOP, // open loop voltage control
        PATH_FOLLOWING, // velocity PID control
    }

    public static class PeriodicIO {
        // INPUTS
        public int left_position_ticks;
        public int right_position_ticks;
        public double left_distance;
        public double right_distance;
        public int left_velocity_ticks_per_100ms;
        public int right_velocity_ticks_per_100ms;
        public Rotation2d gyro_heading = Rotation2d.identity();
        public Pose2d error = Pose2d.identity();

        // OUTPUTS
        public double left_demand;
        public double right_demand;
        public double left_accel;
        public double right_accel;
        public double left_feedforward;
        public double right_feedforward;
        public TimedState<Pose2dWithCurvature> path_setpoint = new TimedState<Pose2dWithCurvature>(
                Pose2dWithCurvature.identity());
    }
}