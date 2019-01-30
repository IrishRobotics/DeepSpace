package frc.team2606.lib.drivers;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Timer;
import frc.team2606.lib.util.Util;
import frc.team2606.robot.subsystems.Subsystem;

import java.util.ArrayList;
import java.util.function.DoubleSupplier;

public class VictorSPXChecker {
    public static class CheckerConfig {
        public double mCurrentFloor = 5;
        public double mRPMFloor = 2000;

        public double mCurrentEpsilon = 5.0;
        public double mRPMEpsilon = 500;
        public DoubleSupplier mRPMSupplier = null;

        public double mRunTimeSec = 4.0;
        public double mWaitTimeSec = 2.0;
        public double mRunOutputPercentage = 0.5;
    }

    public static class VictorSPXConfig {
        public String mName;
        public VictorSPX mVictor;

        public VictorSPXConfig(String name, VictorSPX victor) {
            mName = name;
            mVictor = victor;
        }
    }

    private static class StoredVictorSPXConfiguration {
        public ControlMode mMode;
        public double mSetValue;
    }

    public static boolean CheckVictors(Subsystem subsystem, ArrayList<VictorSPXConfig> victorsToCheck,
            CheckerConfig checkerConfig) {
        boolean failure = false;
        System.out.println("////////////////////////////////////////////////");
        System.out
                .println("Checking subsystem " + subsystem.getClass() + " for " + victorsToCheck.size() + " victors.");

        ArrayList<Double> currents = new ArrayList<>();
        ArrayList<Double> rpms = new ArrayList<>();
        ArrayList<StoredVictorSPXConfiguration> storedConfigurations = new ArrayList<>();

        // Record previous configuration for all talons.
        for (VictorSPXConfig config : victorsToCheck) {
            LazyVictorSPX victor = LazyVictorSPX.class.cast(config.mVictor);

            StoredVictorSPXConfiguration configuration = new StoredVictorSPXConfiguration();
            configuration.mMode = victor.getControlMode();
            configuration.mSetValue = victor.getLastSet();

            storedConfigurations.add(configuration);

            // Now set to disabled.
            victor.set(ControlMode.PercentOutput, 0.0);
        }

        for (VictorSPXConfig config : victorsToCheck) {
            System.out.println("Checking: " + config.mName);

            config.mVictor.set(ControlMode.PercentOutput, checkerConfig.mRunOutputPercentage);
            Timer.delay(checkerConfig.mRunTimeSec);

            // Now poll the interesting information.
            /*
             * double current = config.mTalon.getOutputCurrent(); currents.add(current);
             * System.out.print("Current: " + current);
             */

            double rpm = Double.NaN;
            if (checkerConfig.mRPMSupplier != null) {
                rpm = checkerConfig.mRPMSupplier.getAsDouble();
                rpms.add(rpm);
                System.out.print(" RPM: " + rpm);
            }
            System.out.print('\n');

            config.mVictor.set(ControlMode.PercentOutput, 0.0);

            // And perform checks.
            /*
             * if (current < checkerConfig.mCurrentFloor) { System.out.println(config.mName
             * + " has failed current floor check vs " + checkerConfig.mCurrentFloor +
             * "!!"); failure = true; }
             */
            if (checkerConfig.mRPMSupplier != null) {
                if (rpm < checkerConfig.mRPMFloor) {
                    System.out
                            .println(config.mName + " has failed rpm floor check vs " + checkerConfig.mRPMFloor + "!!");
                    failure = true;
                }
            }

            Timer.delay(checkerConfig.mWaitTimeSec);
        }

        // Now run aggregate checks.

        if (currents.size() > 0) {
            Double average = currents.stream().mapToDouble(val -> val).average().getAsDouble();

            if (!Util.allCloseTo(currents, average, checkerConfig.mCurrentEpsilon)) {
                System.out.println("Currents varied!!!!!!!!!!!");
                failure = true;
            }
        }

        if (rpms.size() > 0) {
            Double average = rpms.stream().mapToDouble(val -> val).average().getAsDouble();

            if (!Util.allCloseTo(rpms, average, checkerConfig.mRPMEpsilon)) {
                System.out.println("RPMs varied!!!!!!!!");
                failure = true;
            }
        }

        // Restore victor configurations
        for (int i = 0; i < victorsToCheck.size(); ++i) {
            victorsToCheck.get(i).mVictor.set(storedConfigurations.get(i).mMode, storedConfigurations.get(i).mSetValue);
        }

        return !failure;
    }
}
