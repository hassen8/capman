package models;

import capman.*;
import pcap.spi.PacketBuffer;
import pcap.spi.PacketHeader;
import pcap.spi.Statistics;

class Packet {

    String time;
    String ipVersion;
    String source;
    String dest;
    String data;
    String protocol;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIpVersion(String ipVersion) {
        this.ipVersion = ipVersion;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public String getIpVersion() {
        return ipVersion;
    }

    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public String getData() {
        return data;
    }

    void setHeader(PacketHeader header) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setBuffer(PacketBuffer packetBuffer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setStats(Statistics stats) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean getHeader(PacketHeader header) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean getBuffer(PacketBuffer packetBuffer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean getStats(Statistics stats) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
