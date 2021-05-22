/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capman;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import pcap.spi.Address;
import pcap.spi.Interface;
import pcap.spi.Service;
import pcap.spi.exception.ErrorException;

/**
 *
 * @author Hassen
 */
class GetDeviceList extends Thread {
    
    DeviceList gui;
    
    GetDeviceList(DeviceList gui){
    this.gui = gui;
    }
    @Override
    public void run(){
        try {
            var service = Service.Creator.create("PcapService");
            Iterator<Interface> devices = service.interfaces().iterator();
            
            while (devices.hasNext())
            {
                Interface device = devices.next();
                System.out.println("Name             : " + device.name());
                gui.model.addElement(device.description());
                System.out.println("Description      : " + device.description());
                System.out.println("Flags            : " + device.flags());
                if (device.addresses() != null) {
                    System.out.println("Addresses        : ");
                    Iterator<Address> addresses = device.addresses().iterator();
                    while (addresses.hasNext()) {
                        Address address = addresses.next();
                        System.out.println("\tAddress      : " + address.address());
                        System.out.println("\tNetmask      : " + address.netmask());
                        System.out.println("\tBroadcast    : " + address.broadcast());
                        System.out.println("\tDestination  : " + address.destination());
                    }
                }
                System.out.println();
            }
        } catch (ErrorException ex) {
            Logger.getLogger(GetDeviceList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
