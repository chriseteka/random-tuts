/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerations;

import model.Vehicle;
import model.sub.Bus;
import model.sub.Car;
import model.sub.ElectricCar;
import model.sub.Truck;
import model.sub.Van;

/**
 *
 * @author Chris_Eteka
 */
public enum VehicleType {
    CAR {
        Vehicle getVehicle(){
            return new Car();
        }
    },
    TRUCK {
        Vehicle getVehicle() {
            return new Truck();
        }
    },
    ELECTRIC_CAR {
        Vehicle getVehicle() {
            return new ElectricCar();
        }
    },
    VAN {
        Vehicle getVehicle() {
            return new Van();
        }
    },
    BUS {
        Vehicle getVehicle() {
            return new Bus();
        }
    };    

    abstract Vehicle getVehicle();
}
