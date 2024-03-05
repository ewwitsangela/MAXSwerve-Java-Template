// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CimMotorConstants;

public class intakeSubsystem extends SubsystemBase {

  public WPI_VictorSPX m_intakeLeft, m_intakeRight;

  /** Creates a new intake. */
  public intakeSubsystem() {
    //motors
    m_intakeLeft = new WPI_VictorSPX(CimMotorConstants.kLeftIntakeId);
    m_intakeRight = new WPI_VictorSPX(CimMotorConstants.kRightIntakeId);
  }

  // public void move(double speed){
  //   m_left.set(ControlMode.PercentOutput, speed);
  // }

  public void controllerIntake(XboxController controller) {
    m_intakeLeft.set(controller.getRightTriggerAxis()); //this axis is bound to the range of [0, 1] as opposed to the usual [-1, 1].
    m_intakeRight.set(controller.getRightTriggerAxis());
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
