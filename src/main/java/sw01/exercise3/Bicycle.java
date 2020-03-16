
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw01.exercise3;

import java.awt.Color;

/**
 *
 * @author yannk
 */
public class Bicycle {
    public Person driver;
    public int coolness;
    public Color color;

    public Bicycle(Person driver, int coolness, Color color) {
        this.driver = driver;
        this.coolness = coolness;
        this.color = color;
    }

    /**
     * @override overrides classic toString method
     * @return
     */
    public String toString2() {
        return String.format("driver: %s | coolness: %d | color: %s", this.driver.name, this.coolness, this.color.toString());
    }
}
