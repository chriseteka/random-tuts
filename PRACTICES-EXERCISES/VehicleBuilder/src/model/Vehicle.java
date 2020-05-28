/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Chris_Eteka
 */
public class Vehicle {
    
    private final double price;
    private final String type;
    private final String make;
    private final int horsePower;
    private final String model;
    private final String color;
    private final int doors;
    
    private Vehicle(VehicleBuilder vehicleBuilder){
        this.price = vehicleBuilder.price;
        this.type = vehicleBuilder.type;
        this.make = vehicleBuilder.make;
        this.horsePower = vehicleBuilder.horsePower;
        this.model = vehicleBuilder.model;
        this.color = vehicleBuilder.color;
        this.doors = vehicleBuilder.doors;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "price=" + price + ", type=" + type +
                ", make=" + make + ", horsePower=" + horsePower +
                ", model=" + model + ", color=" + color + ", doors=" + doors + '}';
    }
    
    
    
    public static class VehicleBuilder{
        private double price;
        private String type;
        private String make;
        private int horsePower;
        private String model;
        private String color;
        private int doors;

        //Compulsory fields
        public VehicleBuilder(double price, String type) {
            this.price = price;
            this.type = type;
        }
        
        public VehicleBuilder make(String make){
            this.make = make;
            return this;
        }
        
        public VehicleBuilder model(String model){
            this.model = model;
            return this;
        }
        
        public VehicleBuilder color(String color){
            this.color = color;
            return this;
        }
        
        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}
