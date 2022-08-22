// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final WPI_TalonSRX rightFrontTalon = new WPI_TalonSRX(Constants.RIGHT_FRONT_CAN_ID);
  private final WPI_TalonSRX rightRearTalon = new WPI_TalonSRX(Constants.RIGHT_REAR_CAN_ID);
  private final WPI_TalonSRX leftFrontTalon = new WPI_TalonSRX(Constants.LEFT_FRONT_CAN_ID);
  private final WPI_TalonSRX leftRearTalon = new WPI_TalonSRX(Constants.LEFT_REAR_CAN_ID);

  //Create motor groups
  private final MotorControllerGroup rightDrive = new MotorControllerGroup(rightFrontTalon, rightRearTalon);
  private final MotorControllerGroup leftDrive = new MotorControllerGroup(leftFrontTalon, leftRearTalon);

  // Drivetrain
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftDrive, rightDrive);

  public Drivetrain() {
    diffDrive.setDeadband(Constants.DEADBAND_SIZE);
  }

  // public void init() {
  //   rightFrontTalon.setInverted(false);
  //   rightRearTalon.setInverted(false);
  //   // leftFrontTalon.setInverted(true);
  //   // leftRearTalon.setInverted(true);
  // // }
  
  // public void Drive(double x, double y) {
  //   rightFrontTalon.set(ControlMode.PercentOutput, y);
  //   rightRearTalon.set(ControlMode.PercentOutput, y);
  //   leftFrontTalon.set(ControlMode.PercentOutput, y);
  //   leftRearTalon.set(ControlMode.PercentOutput, y);
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    diffDrive.arcadeDrive(RobotContainer.getJoyX()*Constants.SPEED_FACTOR, RobotContainer.getJoyY()*Constants.SPEED_FACTOR);
  }
}
