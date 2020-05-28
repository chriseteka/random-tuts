package models;

import static models.Device.deviceName;

/**
 *
 * @author Chris_Eteka
 */
public class RemoteController {
    
    private Device device;
    private static final RemoteController INSTANCE = new RemoteController();
    
    public static RemoteController getInstance(){
        return INSTANCE;
    }

    public void selectDevice(Device device) {
        this.device = device;
        if (this.device == null){
            System.out.println("No device selected");
            return;
        }
        System.out.println("Selected device: " + deviceName);
    }

    public void turnOn() {
        if (this.device == null){
            System.out.println("No device selected");
            return;
        }
        this.device.turnDeviceOn();
    }

    public void turnOff() {
        if (this.device == null){
            System.out.println("No device selected");
            return;
        }
        this.device.turnDeviceOff();
    }       
}
