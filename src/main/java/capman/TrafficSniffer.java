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
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TrafficSniffer extends Thread {

    public ArrayList<Packets> readFile(String fileName) {
        ArrayList<Packets> packets = new ArrayList<>();
        try {
            while (true) {
                File myObj = new File(fileName);
                Scanner myReader = new Scanner(myObj);

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    Thread.sleep(500);
                    packets.add(parseData(data));
                }
                myReader.close();
               

            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return packets;
    }

    public Packets parseData(String data) {

        String[] seg = data.split("\\s");
        String time = seg[0];
        String ipVersion = seg[1];
        String source = seg[2];
        String dest = seg[4].replace(':', ' ');
        seg = data.split(":\\s");
        String Data = seg[1];
        System.out.println(Data);

        Packets packet = new Packets();
        packet.setTime(time);
        packet.setIpVersion("IpV4");
        packet.setDest(dest);
        packet.setSource(source);
        packet.setData(Data);
        return packet;
    }

    public Packets capture() throws InterruptedException {

        Packets packets = new Packets();
        try {
            Process process = Runtime.getRuntime().exec("windump -c 6000");
            packets = printResults(process);
            return packets;

        } catch (IOException e) {
        }
        Thread.sleep(1000);
        return packets;
    }

    public void capturing() {
        try {
            Process process = Runtime.getRuntime().exec("execute.bat");
        } catch (IOException e) {
        }
    }

    public ArrayList<Packets> captureArrayList() {
        ArrayList<Packets> packet = new ArrayList<>();
        Packets packets = new Packets();
        try {
            Process process = Runtime.getRuntime().exec("windump -c 1");
            packets = printResults(process);
            packet.add(packets);
            return packet;

        } catch (IOException e) {
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        return packet;
    }

    public Packets printResults(Process process) {
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (reader.readLine().length() > 0) {
                line = reader.readLine();
                return parseData(line);
            }
        } catch (IOException e) {

        }

        return parseData(line);
    }

    @Override
    public void run() {
        try {
            capture();
        } catch (InterruptedException ex) {

        }
    }

}
