package frc.team3100.robot;


import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Commands.MotorRun;
import frc.team3100.robot.Commands.MotorRun1;
import frc.team3100.robot.Commands.WallExtend;

public class OI {

    Button piston = new JoystickButton(RobotMap.techControls, RobotMap.rightBumperChannel);
  //  Button driveAuto = new JoystickButton(RobotMap.driveControls, RobotMap.leftBumperChannel);
    Button motorRun = new JoystickButton(RobotMap.techControls, RobotMap.bButtonChannel);
    Button motorRun1 = new JoystickButton(RobotMap.techControls, RobotMap.yButtonChannel);


    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // button.whenPressed(new ExampleCommand());

    // button.whileHeld(new ExampleCommand());

    // button.whenReleased(new ExampleCommand());

    public OI() {

        piston.toggleWhenPressed(new WallExtend());


    //    driveAuto.whenPressed(new AutoDrive());
        motorRun.whenPressed(new MotorRun());
        motorRun1.whenPressed(new MotorRun1());


    }


}