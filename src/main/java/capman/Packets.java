/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capman;

/**
 *
 * @author Hassen
 */
public class Packets {
  String time;
  String ipVersion;
  String source;
  String dest;
  String data;

  public void setTime(String time) {
    this.time = time.substring(0, 8);
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

