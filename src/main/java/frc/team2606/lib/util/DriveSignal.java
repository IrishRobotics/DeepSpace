package frc.team2606.lib.util;

/**
 * A drivetrain command consisting of the left, right motor settings and whether
 * the brake mode is enabled.
 */
public class DriveSignal {
    protected double frontLeft;
    protected double frontRight;
    protected boolean brakeMode;

    public DriveSignal(double left, double right) {
        this(left, right, false);
    }

    public DriveSignal(double left, double right, boolean isBrakeMode) {
        frontLeft = left;
        frontRight = right;
        brakeMode = isBrakeMode;
    }

    public static DriveSignal NEUTRAL = new DriveSignal(0, 0);
    public static DriveSignal BRAKE = new DriveSignal(0, 0, true);

    public double getLeft() {
        return frontLeft;
    }

    public double getRight() {
        return frontRight;
    }

    public boolean getBrakeMode() {
        return brakeMode;
    }

    @Override
    public String toString() {
        return "L: " + frontLeft + ", R: " + frontRight + (brakeMode ? ", BRAKE" : "");
    }
}