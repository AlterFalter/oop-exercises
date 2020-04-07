/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw04.exercise2;

/**
 *
 * @author yannk
 */
public class DemoMotor {
    public static void main(String[] arg) {
        Switchable motor = new Motor();
        motor.switchOn();
        try {
            Thread.sleep(25000);
        }
        catch (InterruptedException e) {
            System.out.println("couldn't sleep");
        }
        System.out.println("stopping now");
        motor.switchOff();
    }
}
