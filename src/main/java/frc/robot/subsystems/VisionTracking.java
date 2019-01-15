package frc.robot.subsystems;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Allign;



public class VisionTracking extends PIDSubsystem { // This system extends PIDSubsystem

    double robotAngle;
    double targetAngle;
    double goalAngle;
    double goalDist;
    double leftDrive;
    double rightDrive;
    double coordX;
    double coordY;
    double diviationX;
    double diviationY;
    AHRS ahrs = new AHRS(SPI.Port.kMXP);

	public VisionTracking() {
		super("VisionTracking", RobotMap.PID_P, RobotMap.PID_I, RobotMap.PID_D);// The constructor passes a name for the subsystem and the P, I and D constants that are used when computing the motor output
        setAbsoluteTolerance(0.05);
        setSetpoint(targetAngle);
		getPIDController().setContinuous(false);
    }

    public void visionCalc() {

        diviationX = (coordX - (RobotMap.PICTURE_WIDTH / 2)) / RobotMap.PICTURE_WIDTH * RobotMap.FOV_X;
        diviationY = (coordY - (RobotMap.PICTURE_HEIGHT / 2)) / RobotMap.PICTURE_HEIGHT * RobotMap.FOV_Y;


        if (Robot.isHatch == true) { //calculates distance based on hatch height
            goalDist = (RobotMap.HATCH_TAPE - RobotMap.CAMERA_HEIGHT) / Math.tan(diviationY);
        } else if (Robot.isBall == true) { //calculates distance based on port height
            goalDist = (RobotMap.PORT_TAPE - RobotMap.CAMERA_HEIGHT) / Math.tan(diviationY);
        }
    }
    
    public void setTargetAngle(){
        
        robotAngle = ahrs.getAngle();
        targetAngle = robotAngle + goalAngle;
    }
	
    public void initDefaultCommand() {
        setDefaultCommand(new Allign());
    }

    protected double returnPIDInput() {
    	return ahrs.getAngle(); // returns the sensor value that is providing the feedback for the system
    }

    protected void usePIDOutput(double output) {
    	Robot.drive.move(leftDrive, rightDrive);
        ; // this is where the computed output value fromthe PIDController is applied to
          // the motor
    }
}
