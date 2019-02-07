package frc.team2606.lib.trajectory;

import frc.team2606.lib.geometry.Pose2d;
import frc.team2606.lib.geometry.Twist2d;

public interface IPathFollower {
    public Twist2d steer(Pose2d current_pose);

    public boolean isDone();
}
