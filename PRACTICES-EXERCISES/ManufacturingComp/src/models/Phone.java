package models;

/**
 *
 * @author Chris_Eteka
 */
public class Phone extends Device{

    public Phone(String deviceName) {
        super(deviceName);
    }

    void assembleDevice() {
        System.out.println("Assembling phone");
    }

    void testDevice() {
        System.out.println("Testing phone");
    }

    void packageDevice() {
        System.out.println("Packaging phone");
    }

    void storeDevice() {
        System.out.println("Storing phone");
    }
    
}
