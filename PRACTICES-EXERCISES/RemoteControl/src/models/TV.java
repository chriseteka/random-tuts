package models;

/**
 *
 * @author Chris_Eteka
 */
public class TV extends Device{
    
    public TV(String device) {
        super(device);
    }  

    void turnDeviceOn() {
        System.out.println("Turning on the tv");
    }

    void turnDeviceOff() {
        System.out.println("Turning off the tv");
    }
}
