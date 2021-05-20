/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Hassen
 */
public class Capture {
     public static void main(String[] args) throws IOException {
        int i=0;
        while(i<=5){
        Process process = Runtime.getRuntime().exec("windump -c 1");
        printResults(process);
        i++;}
       }

    public static void printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        line = reader.readLine();
        
    }
}
