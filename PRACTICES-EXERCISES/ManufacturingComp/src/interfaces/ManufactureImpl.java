package interfaces;

import models.Device;

/**
 *
 * @author Chris_Eteka
 */
public class ManufactureImpl implements Manufacture{

    public void manufacture(Device device) {
        device.launchProcess();
    }
}
