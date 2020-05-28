package models;

/**
 *
 * @author Chris_Eteka
 */
public class SoundSystem extends Device{
    
    public SoundSystem(String device) {
        super(device);
    }

    void turnDeviceOn() {
        System.out.println("Turning on the sound  system");
    }

    void turnDeviceOff() {
        System.out.println("Turning off the sound system");
    }
}
