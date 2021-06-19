package capman;

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
    String header;
    String buffer;
    String stats;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }
    
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

   

}
