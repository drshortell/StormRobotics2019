package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

public class Airsystem extends Subsystem {
     //private AxisCamera camera;                       //defines Axis Camera
     private Solenoid solPickUp;
     private Solenoid solPunch;                             //defines solenoids
     private Solenoid solHab;
     private Solenoid solArm;

     public Airsystem() {
          Compressor airCompressor = new Compressor();  //Digtial I/O,Relay
          airCompressor.start();                        // Start the air compressor

          solPickUp = new Solenoid(RobotMap.SOL_PICKUP_PORT);                        // Solenoid port
          solPunch = new Solenoid(RobotMap.SOL_PUNCH_PORT);
          solHab = new Solenoid(RobotMap.SOL_HAB_PORT);
          solArm = new Solenoid(RobotMap.SOL_ARM_PORT);

     }

     public void pickupHatch(){
         solPickUp.set(!solPickUp.get());
         
     }

     public void punchHatch(){
        solPunch.set(!solPunch.get());
        
    }

    @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand();
  }
}
