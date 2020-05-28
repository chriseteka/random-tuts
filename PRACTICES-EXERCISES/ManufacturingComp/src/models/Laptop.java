package models;

/**
 *
 * @author Chris_Eteka
 */
public class Laptop extends Device{

    public Laptop(String deviceName) {
        super(deviceName);
    }

    void assembleDevice() {
        System.out.println("Assembling laptop");
    }

    void testDevice() {
        System.out.println("Testing laptop");
    }

    void packageDevice() {
        System.out.println("Packaging laptop");
    }

    void storeDevice() {
        System.out.println("Storing laptop");
    }
    
}
