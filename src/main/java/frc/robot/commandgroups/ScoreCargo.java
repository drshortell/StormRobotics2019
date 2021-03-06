package frc.robot.commandgroups;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScoreCargo extends CommandGroup {

    public ScoreCargo() { //might have to fix this stuff pranay
        addSequential(new DriveDistance(100.0, 1.0));
        addParallel(new ToggleArm());
        addSequential(new FollowLine());
        addSequential(new TogglePunch());
        addSequential(new DriveDistance(-100.0, 1.0));
        addSequential(new TogglePunch());
        addSequential(new ToggleArm());
    }
}