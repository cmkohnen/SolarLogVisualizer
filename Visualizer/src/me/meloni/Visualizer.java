package me.meloni;

import me.meloni.FileReading.Reader;

import java.io.IOException;

public class Visualizer {

    public static final String version = "0.0.0.0.1";


    public static void main(String[] args) throws IOException {
        // write your code here
        //MainWindow.createwindow();

        //System.out.println(Reader.usefullinfo());

        for(int i = 0; i < Reader.mindata().size() - 1; i++) {
          System.out.println(Reader.mindata().get(i));
        }
        //System.out.println(Reader.mindata().get(9215));









    }
}
