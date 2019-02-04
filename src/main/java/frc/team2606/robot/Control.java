package frc.team2606.robot;

public class Control {
    private static Control instance = null;

    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        return instance;
    }

    // Intake
    public boolean getIntakePosition() {
        return false;
    }

    public boolean getRunIntake() {
        return false;
    }

    public boolean isBall() {
        return false;
    }

    // Arm Heights

}