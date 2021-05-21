/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capman;

import java.util.Date;
import pcap.codec.ethernet.Ethernet;
import pcap.codec.ip.Ip4;
import pcap.codec.ip.Ip6;
import pcap.spi.Interface;
import pcap.spi.PacketBuffer;
import pcap.spi.PacketHeader;
import pcap.spi.Service;
import pcap.spi.exception.TimeoutException;
import pcap.spi.exception.error.BreakException;
import pcap.spi.option.DefaultLiveOptions;

/**
 *
 * @author Hassen
 */
class CaptureTraffic extends Thread {

  private GUI gui;

  CaptureTraffic(GUI gui) {
    this.gui = gui;
  }

  @Override
  public void run() {
    PacketSniffer packetSniffer = new PacketSniffer();

    Service service = packetSniffer.createService();
    Interface device = packetSniffer.getDevice(service,gui.deviceIndex);

    try {
      var pcap = service.live(device, new DefaultLiveOptions());
      PacketHeader header = pcap.allocate(PacketHeader.class);
      PacketBuffer packetBuffer = pcap.allocate(PacketBuffer.class);

      while (!Thread.currentThread().isInterrupted()) {
        try {
          Packet packet = new Packet();

          pcap.nextEx(header, packetBuffer);

          Date date = new Date(header.timestamp().second() * 1000);
          packet.setTime(date.toString());

          Ethernet ethernet = packetBuffer.cast(Ethernet.class);
          if (ethernet.type() == Ip4.TYPE) {
            Ip4 ip4 = packetBuffer.readerIndex(ethernet.size()).cast(Ip4.class);
            packet.setIpVersion("IPv4");
            packet.setSource(ip4.source().getHostAddress());
            packet.setDest(ip4.destination().getHostAddress());
          } else if (ethernet.type() == Ip6.TYPE) {
            Ip6 ip6 = packetBuffer.readerIndex(ethernet.size()).cast(Ip6.class);
            packet.setIpVersion("IPv6");
            packet.setSource(ip6.source().getHostAddress());
            packet.setDest(ip6.destination().getHostAddress());
          }

          gui.addRow(packet);
          gui.scrollToBottom();
          gui.updatePacketsCount();

          try {
            this.sleep(100);
          } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (this.currentThread().getState() == Thread.State.RUNNABLE) {
              this.interrupt();
            }
          }

        } catch (BreakException e) {
          System.out.println(e.getMessage());
        } catch (TimeoutException e) {
          System.out.println(e.getMessage());
        }
      }
    } catch (Exception ex) {
      System.out.println("Could not capture packet: " + ex);
    }
  }
}
