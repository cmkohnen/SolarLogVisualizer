package me.meloni;

import me.meloni.DataStorage.Read;
import me.meloni.Tools.DateConverter;
import me.meloni.UserGUI.MainWindow;

import java.io.IOException;
import java.util.Arrays;

public class Visualizer {

    public static final int fileversion = 1;
    public static final String version = "0.0.5";
    public static boolean debug = false;

    public static void main(String[] args) throws IOException {
        if(Arrays.toString(args).contains("-debug")){
            debug = true;
        }
        // write your code here
        MainWindow.create();
    }
}
