/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerations;

import model.Vehicle;

/**
 *
 * @author Chris_Eteka
 */
public class VehicleFactory {
    public Vehicle getVehicle(VehicleType vehicleType){
        return vehicleType.getVehicle();
    }
}
