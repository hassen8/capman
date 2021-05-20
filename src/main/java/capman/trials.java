/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hassen
 */
public class trials {

    public static void main(String[] args) {
            int i=0;
        try {
            Process process = Runtime.getRuntime().exec("windump -c 1");
            while(i<10){
                Thread.sleep(2000);
                printResults(process);
            i++;
            }
        } catch (Exception e) {

        }

    }
    public static void printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((reader.readLine()) != null) {
            System.out.println(line);
            try {
            } catch (Exception e) {
            }
        }
    }
}
