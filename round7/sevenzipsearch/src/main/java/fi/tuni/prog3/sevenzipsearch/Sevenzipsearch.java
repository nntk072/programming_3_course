/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package fi.tuni.prog3.sevenzipsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.compress.archivers.sevenz.*;

/**
 *
 * @author xblong
 */
public class Sevenzipsearch {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        // TODO code application logic here
        try (SevenZFile sevenZFile = new SevenZFile(new File(args[0]))) {
            SevenZArchiveEntry entry = sevenZFile.getNextEntry();
            while(entry !=null) {
                if(entry.getName().toLowerCase().endsWith(".txt")) {
                    System.out.println(entry.getName());
                    try(var file = new BufferedReader(new InputStreamReader(sevenZFile.getInputStream(entry)))) {
                        
                        String line;
                        int lineNumber = 0;
                        while((line = file.readLine()) != null) {
                            lineNumber +=1;
                            if(line.toLowerCase().contains(args[1].toLowerCase())){
                                System.out.println(lineNumber + ": " + line.replaceAll("(?i)" + args[1], args[1].toUpperCase()));
                            }   
                         }
                        System.out.println();
                    }
                }
                entry = sevenZFile.getNextEntry();
            }
        }
    }
}
