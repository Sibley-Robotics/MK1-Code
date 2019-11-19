package frc.team3100.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.RobotMap;

public class MotorRun extends Command {

    protected void initialize() {

    }

    //Testing command to run motors
    protected void execute() {

        if (RobotMap.driveControls.getButtonB()) {

            RobotMap.auxMotor.set(-1);
            RobotMap.auxMotor2.set(-1);

        } else {

            RobotMap.auxMotor.set(0);
            RobotMap.auxMotor2.set(0);

        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}