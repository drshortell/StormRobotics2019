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
import edu.wpi.first.wpilibj.AnalogInput;

public class LineFollower extends Subsystem {
     //private AxisCamera camera;                       //defines Axis Camera
     private AnalogInput lineRight;
     private AnalogInput lineLeft;
     private AnalogInput lineMiddle;

     
     


     public LineFollower() {
        
        RobotMap.LIGHT_THRESHOLD = 2000; // limit for tape values 

        lineLeft = new AnalogInput(RobotMap.PHO_LEFT_PORT);
        lineMiddle = new AnalogInput(RobotMap.PHO_MIDDLE_PORT);                        // Solenoid port
        lineRight = new AnalogInput(RobotMap.PHO_RIGHT_PORT);

     }

     public void followLine(){
      switch (updateState()){
        case("000"):
          // stop motors;
        case("100"):
          // drive left;
        case("010"):
          // drive forward;
        case("001"):
          // drive right;
        case("110"):
          // drive left slowly;
        case("011"):
          // drive right slowly;
        case("111"):
          // error, shouldnt be possible
      }
        


     }

     public String updateState() {
      return isLine(lineLeft) + isLine(lineMiddle) + isLine(lineRight);
     }


     public String isLine(AnalogInput lineFollow) {
        if (lineFollow.getValue() >= RobotMap.LIGHT_THRESHOLD) {
          return "1";
        } 

        return "0";
     }

    @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand();
  }
}