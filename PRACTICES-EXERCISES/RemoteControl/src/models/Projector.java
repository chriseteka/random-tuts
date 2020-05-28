package models;

/**
 *
 * @author Chris_Eteka
 */
public class Projector extends Device{

    public Projector(String device) {
        super(device);
    }

    void turnDeviceOn() {
        System.out.println("Turning on the projector");
    }

    void turnDeviceOff() {
        System.out.println("Turning off the projector");
    }
}
