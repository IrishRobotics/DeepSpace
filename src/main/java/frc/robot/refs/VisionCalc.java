package frc.robot.refs;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class VisionCalc {

    double robotAngle;
    double targetAngle;
    double goalAngle;
    double goalDist;
    double coordX;
    double coordY;
    double diviationX;
    double diviationY;

    public VisionCalc() {
        diviationX = (coordX - (RobotMap.PICTURE_WIDTH / 2)) / RobotMap.PICTURE_WIDTH * RobotMap.FOV_X;
        diviationY = (coordY - (RobotMap.PICTURE_HEIGHT / 2)) / RobotMap.PICTURE_HEIGHT * RobotMap.FOV_Y;
        
        if (Robot.isHatch == true) { //calculates distance based on hatch height
            goalDist = (RobotMap.HATCH_TAPE - RobotMap.CAMERA_HEIGHT) / Math.tan(diviationY);
        } else if (Robot.isBall == true) { //calculates distance based on port height
            goalDist = (RobotMap.PORT_TAPE - RobotMap.CAMERA_HEIGHT) / Math.tan(diviationY);
        }
    }
}