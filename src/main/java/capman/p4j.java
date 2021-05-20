/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capman;

import java.io.IOException;
import static java.lang.Character.LINE_SEPARATOR;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.Packet;

/**
 *
 * @author Hassen
 */
public class p4j {
    
    public static void main(String[] args) {
                InetAddress addr;
        PcapNetworkInterface nif;
        int snapLen = 65536;
        try {
            addr = InetAddress.getByName("192.168.43.18");
            System.out.println("hello");
            nif = Pcaps.getDevByAddress(addr);
            System.out.println("hello");
            PromiscuousMode mode = PromiscuousMode.PROMISCUOUS;
            int timeout = 10;
            PcapHandle handle = nif.openLive(snapLen, mode, timeout);
            Packet packet = handle.getNextPacketEx();
            handle.close();
            IpV4Packet ipV4Packet = packet.get(IpV4Packet.class);
            Inet4Address srcAddr = ipV4Packet.getHeader().getSrcAddr();
            System.out.println(srcAddr);
        } catch (Exception e) {
            System.out.println(e);
        }


    }
    
}
