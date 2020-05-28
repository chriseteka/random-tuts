package main;

import interfaces.ManufactureImpl;
import models.Device;
import models.Laptop;
import models.Phone;

/**
 *
 * @author Chris_Eteka
 */
public class Producer {
    
    private static final ManufactureImpl manufacture = new ManufactureImpl();
    
    public static void main(String[] args) {
                
        Device techno = new Phone("TECHNO PHONE");
        Device hp = new Laptop("HP LAPTOP");
                
        manufacture.manufacture(techno);
        manufacture.manufacture(hp);
    }
    
}
