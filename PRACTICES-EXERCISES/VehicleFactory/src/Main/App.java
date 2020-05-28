/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import enumerations.VehicleFactory;
import static enumerations.VehicleType.*;
import model.Vehicle;

/**
 *
 * @author Chris_Eteka
 */
public class App {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.getVehicle(CAR);
        vehicle.startEngine();
    }
}
