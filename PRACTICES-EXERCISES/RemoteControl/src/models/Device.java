package models;

/**
 *
 * @author Chris_Eteka
 */
abstract public class Device{
    
    public static String deviceName;

    public Device(String deviceName) {
        Device.deviceName = deviceName;
    }

    abstract void turnDeviceOn();
    
    abstract void turnDeviceOff();
}
