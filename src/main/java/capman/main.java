/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capman;

import java.util.Iterator;
import pcap.codec.ethernet.Ethernet;
import pcap.codec.ip.Ip4;
import pcap.codec.ip.Ip6;
import pcap.codec.tcp.Tcp;
import pcap.codec.udp.Udp;
import pcap.spi.Address;
import pcap.spi.Interface;
import pcap.spi.PacketBuffer;
import pcap.spi.PacketHeader;
import pcap.spi.Service;
import pcap.spi.option.DefaultLiveOptions;

/**
 *
 * @author Hassen
 */
public class main {

    public static void main(String[] _args) throws Exception {
        var service = Service.Creator.create("PcapService");
        Iterator<Interface> devices = service.interfaces().iterator();
        System.out.println();
        Interface device = devices.next().next().next().next().next().next();

        try (var pcap = service.live(device, new DefaultLiveOptions())) {
            PacketHeader header = pcap.allocate(PacketHeader.class);
            PacketBuffer packetBuffer = pcap.allocate(PacketBuffer.class);
            for (int i = 0; i < 1000; i++) {
                try {
                    pcap.nextEx(header, packetBuffer);
                    System.out.println("Header   : " + header);
                    System.out.println("Packet   : " + packetBuffer);

                    Ethernet ethernet = packetBuffer.cast(Ethernet.class);
                    System.out.println(ethernet.type());

                    if (ethernet.type() == Ip4.TYPE) {
                        Ip4 ip4 = packetBuffer.readerIndex(ethernet.size()).cast(Ip4.class);
                        System.out.println("IPV4");
                        System.out.println(ip4.source().getHostAddress());
                        if (ip4.protocol() == Tcp.TYPE) {
                            Tcp tcp = packetBuffer.readerIndex(ethernet.size() + ip4.size()).cast(Tcp.class);
                            System.out.println("TCP");
                            System.out.println(tcp);
                        } else if (ip4.protocol() == Udp.TYPE) {
                            Udp udp = packetBuffer.readerIndex(ethernet.size() + ip4.size()).cast(Udp.class);
                            System.out.println("UPD");
                            System.out.println(udp);
                        }
                    } else if (ethernet.type() == Ip6.TYPE) {
                        Ip6 ip6 = packetBuffer.readerIndex(ethernet.size()).cast(Ip6.class);
                        System.out.println("IPV6");
                        System.out.println(ip6);
                        if (ip6.nextHeader() == Tcp.TYPE) {
                            Tcp tcp = packetBuffer.readerIndex(ethernet.size() + ip6.size()).cast(Tcp.class);
                            System.out.println("TCP");
                            System.out.println(tcp);
                        } else if (ip6.nextHeader() == Udp.TYPE) {
                            Udp udp = packetBuffer.readerIndex(ethernet.size() + ip6.size()).cast(Udp.class);
                            System.out.println("UPD");
                            System.out.println(udp);
                        }
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());

                }
            }
        }
    }
}

//        while (devices.hasNext()) {
//            Interface device = devices.next();
//            System.out.println("Name             : " + device.name());
//            System.out.println("Description      : " + device.description());
//            System.out.println("Flags            : " + device.flags());
//            if (device.addresses() != null) {
//                System.out.println("Addresses        : ");
//                Iterator<Address> addresses = device.addresses().iterator();
//                while (addresses.hasNext()) {
//                    Address address = addresses.next();
//                    System.out.println("\tAddress      : " + address.address());
//                    System.out.println("\tNetmask      : " + address.netmask());
//                    System.out.println("\tBroadcast    : " + address.broadcast());
//                    System.out.println("\tDestination  : " + address.destination());
//                }
//            }
//            System.out.println();
//        try (var pcap = service.live(device, new DefaultLiveOptions())) {
//            try {
//                pcap.loop(
//                        1000,
//                        (args, header, buffer) -> {
//                            System.out.println("Args     : " + args);
//                            System.out.println("Header   : " + header);
//                            System.out.println("Packet   : " + buffer);
//                        },
//                        "Hello pcap!");
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//
//            }
//        }

