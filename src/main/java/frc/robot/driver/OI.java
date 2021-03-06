/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.driver;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.constants.*;

import frc.robot.commands.*;
import frc.robot.commandgroups.*;
import frc.robot.constants.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    private Controller driver = new Controller(ControllerMap.DRIVER_PORT);
    private Controller weapons = new Controller(ControllerMap.WEAPONS_PORT);


    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.

    public OI() {

        weapons.getABtn().whenPressed(new ToggleGrab());
        weapons.getBBtn().whenPressed(new TogglePunch());
        weapons.getXBtn().whenPressed(new ToggleArm());
        weapons.getYBtn().whenPressed(new ToggleHab());

        weapons.getLB().whenPressed(new TogglePickupCargo());
        weapons.getRB().whenPressed(new ToggleShoot());

        driver.getLT().whileHeld(new CheckLine());

    }

    public double getLeftSpeed() {
        return driver.getY(GenericHID.Hand.kLeft);
    }

    public double getRightSpeed() {
        return driver.getY(GenericHID.Hand.kRight);
    }

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


}
