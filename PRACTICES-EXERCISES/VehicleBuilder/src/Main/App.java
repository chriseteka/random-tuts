/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import model.Vehicle;

/**
 *
 * @author Chris_Eteka
 */
public class App {
    
    public static void main(String[] args) {
        Vehicle honda = new Vehicle.VehicleBuilder(400, "Saloon")
                .color("white")
                .make("Honda")
                .model("655")
                .build();
        
        System.out.println(honda);
    }
    
}
