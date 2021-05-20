package capman;

class Packet {

  String time;
  String ipVersion;
  String source;
  String dest;
  String data;

  public void setTime(String time) {
    // this.time = time.substring(0, 8);
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
