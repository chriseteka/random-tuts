/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sub;

import model.Vehicle;

/**
 *
 * @author Chris_Eteka
 */
public class ElectricCar implements Vehicle{
    public void startEngine() {
        System.out.println("Starting electric car by joining wires");
    }
}
