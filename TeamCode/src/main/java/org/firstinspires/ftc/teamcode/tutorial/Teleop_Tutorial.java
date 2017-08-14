package org.firstinspires.ftc.teamcode.tutorial;

//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Student on 8/12/2017.
 */
@TeleOp(name = "Teleop_Tutorial")
public class Teleop_Tutorial extends OpMode {
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private Servo arm;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        arm = hardwareMap.servo.get("arm");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void start() {
        leftMotor.setPower(0.0);
        rightMotor.setPower(0);
        arm.setPosition(0);
    }

    @Override
    public void loop() {

        arcadeDrive(-1*gamepad1.left_stick_y, gamepad1.right_stick_y);
    }

    @Override
    public void stop() {

    }

    public void arcadeDrive(double power, double turn) {
        double leftPower = Range.clip(power + turn, -1, 1);
        double rightPower = Range.clip(power - turn, -1, 1);

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }

}
