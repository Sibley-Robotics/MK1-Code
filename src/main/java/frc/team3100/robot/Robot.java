package frc.team3100.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team3100.robot.Drivetrain.Drive;
import frc.team3100.robot.Shooter.Shooter;


@SuppressWarnings("ALL")
//Main class where everything is defined
public class Robot extends TimedRobot {


    //If mode = 1, Arcade
    //If mode = 2, Tank
    public static int mode = 1;


    //Defining Subsystems
    public static OI oi;
    public static Drive drive;
    public static Shooter shooter;
    public static SpeedControllerSetUp speedcontrollersetup;

    public double pi;
    private boolean ran = false;


    //Commands to be used later
    public static boolean autoVal;
    public static String gameData;
    //private Command autonomousCommand;
    private SendableChooser<Character> autoSide;
    private SendableChooser<Character> autoGroup;
  //  private SendableChooser<Command> chooser = new SendableChooser<>();


    @Override
    //Initalizing
    public void robotInit() {


        //Initalizes the drive subsystem
        drive = new Drive();
        shooter = new Shooter();


        //Sets up the camera
        CameraServer.getInstance().startAutomaticCapture();
        //For limelight, use 10.31.0.11:5801
        //Gets what type of game is being played, not that important
        gameData = DriverStation.getInstance().getGameSpecificMessage();

        //Testing Features - Ignore
        NetworkTable.getTable("SmartDashboard").putDouble("Pi", 3);
        pi = NetworkTable.getTable("SmartDashboard").getDouble("Pi", 0);


        // ALWAYS INIT OI LAST

       // chooser.setDefaultOption("Auto Master", new AutonomousMaster(autoGroup.getSelected(), gameData, autoSide.getSelected()));

     //   autonomousCommand = new AutonomousMaster(autoGroup.getSelected(), gameData, autoSide.getSelected());

        //Autonomous Master Class


        //Options in the Smartdashboard
        autoGroup = new SendableChooser<>();
        autoGroup.addDefault("Group 1", '1');
        autoGroup.addObject("Group 2", '2');
        autoGroup.addObject("Group 3", '3');
        autoGroup.addObject("Group 4", '4');
        autoGroup.addObject("Test 5", '5');
        SmartDashboard.putData("Autonomous", autoGroup);

        autoSide = new SendableChooser<>();
        autoSide.addObject("Left Side", 'L');
        autoSide.addDefault("Right Side", 'R');
        SmartDashboard.putData("Side", autoSide);


       // SmartDashboard.putData(drive);
        oi = new OI();
        new SpeedControllerSetUp().configure();


    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {

    }

 //   @Override
  //  public void disabledPeriodic() {
   //     Scheduler.getInstance().run();
  //  }


    @Override
    public void autonomousInit() {

     //   autonomousCommand = new AutonomousMaster(autoGroup.getSelected(), gameData, autoSide.getSelected());
     //   autonomousCommand.start();
        //Tells the autonomous command to run
        autoVal = true;

        // schedule the autonomous command (example)
       // if (autonomousCommand != null) {
    //        autonomousCommand.start();
    //    }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {

      //  Scheduler.getInstance().run();

    }

    @Override
    public void teleopInit() {

        if(autoVal) {
      //      if(autonomousCommand.isRunning()) {
      //          autonomousCommand.cancel();
            }
        }
      //  autoVal = false;
       // autonomousCommand.cancel();


        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
      //  if (autonomousCommand != null) {
     //       autonomousCommand.cancel();
     //   }

    }

    /**
     * This function is called periodically during operator control.
     */
   // @Override
  //  public void teleopPeriodic() {
   //     Scheduler.getInstance().run();
   // }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {


    }
}

