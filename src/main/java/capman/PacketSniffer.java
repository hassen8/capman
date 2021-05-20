package capman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import pcap.spi.Interface;
import pcap.spi.Service;

public class PacketSniffer {

  PacketSniffer() {
  }

  public Service createService() {
    Service service = null;

    try {
      service = Service.Creator.create("PcapService");
    } catch (Exception ex) {
      System.out.println("Could not create service: " + ex);
    }

    return service;
  }

  public Interface getDevice(Service service) {
    Interface device = null;

    try {
      Iterator<Interface> devices = service.interfaces().iterator();
      device = devices.next();
      System.out.println("Device selected: " + device.name());
    } catch (Exception ex) {
      System.out.println("Could not get device: " + ex);
    }

    return device;
  }

  public ArrayList<Packet> readFile() {
    ArrayList<Packet> packets = new ArrayList<>();

    try {
      File file = new File("dump.txt");
      Scanner reader = new Scanner(file);

      while (reader.hasNextLine()) {
        String data = reader.nextLine();

        // Parse the data
        String[] seg = data.split("\\s");
        String time = seg[0];
        String ipVersion = seg[1];
        String source = seg[2];
        String dest = seg[4];

        Packet packet = new Packet();
        packet.setTime(time);
        packet.setIpVersion(ipVersion);
        packet.setDest(dest);
        packet.setSource(source);
        packet.setData(data);

        packets.add(packet);
      }

      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Cannot read from file: " + e);
    }

    return packets;
  }

}
