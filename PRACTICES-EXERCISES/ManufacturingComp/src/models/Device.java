package models;

/**
 *
 * @author Chris_Eteka
 */
 public abstract class Device{
    
    private final  String deviceName;

    public Device(String deviceName) {
        this.deviceName = deviceName;
    }
    
    abstract void assembleDevice();
    abstract void testDevice();
    abstract void packageDevice();
    abstract void storeDevice();
    
    public void launchProcess(){
        System.out.println("Manufacturing process starts on device: " + deviceName);
        assembleDevice();
        testDevice();
        packageDevice();
        storeDevice();
    }
}
