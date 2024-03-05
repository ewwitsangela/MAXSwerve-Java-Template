// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BagMotorConstants;

public class IntakeSubsystem extends SubsystemBase {

  public WPI_VictorSPX m_intakeLeft, m_intakeRight;

  /** Creates a new intake. */
  public IntakeSubsystem() {
    //motors
    m_intakeLeft = new WPI_VictorSPX(BagMotorConstants.kLeftIntakeId);
    m_intakeRight = new WPI_VictorSPX(BagMotorConstants.kRightIntakeId);
  }

  // public void move(double speed){
  //   m_left.set(ControlMode.PercentOutput, speed);
  // }

  // public void laaintake(XboxController controller) {
  //   m_intakeLeft.set(controller.getRightTriggerAxis()); 
  //   //m_intakeRight.set(controller.getRightTriggerAxis());
  //   m_intakeRight.follow(m_intakeLeft);
  // }

  public void intake(double speed, double deadband) {
    m_intakeLeft.set(speed*deadband);
    m_intakeRight.follow(m_intakeLeft);
  }
  
  public void stop() {
    m_intakeLeft.stopMotor();
    m_intakeRight.stopMotor();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
