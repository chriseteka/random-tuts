package main;

import models.Device;
import models.Projector;
import models.RemoteController;
import models.SoundSystem;
import models.TV;

/**
 *
 * @author Chris_Eteka
 */
public class Person {
    
    private static Device device;
    private static final RemoteController remote = RemoteController.getInstance();
    
    public static void main(String[] args) {
        
        device = new Projector("Dell Projecor");
        executeAllActions();
        
        device = new TV("Hp TV");
        executeAllActions();
        
        device = new SoundSystem("Sony Sound System");
        executeAllActions();
        
        device = null;
        executeAllActions();
        
        Projector scamTin = new Projector("SCAMMER");
        remote.selectDevice(scamTin);
        remote.turnOn();
        remote.turnOff();
    }
    
    private static void executeAllActions(){
        remote.selectDevice(device);
        remote.turnOn();
        remote.turnOff();
        System.out.println("_______________________________________________");
    }
}
