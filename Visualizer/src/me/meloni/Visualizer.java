package me.meloni;

import me.meloni.UserGUI.MainWindow;

import java.io.IOException;
import java.util.Arrays;

/**
 * Main Visualizer Class
 *
 * @author ChaosMelone9
 *
 * @since 0.0.1
 */

public class Visualizer {
    /**
     * Specification of the fileversion used for ".solarlog"-files
     *
     * @since 0.0.5
     */
    public static final int fileversion = 1;

    public static final String version = "0.1.1";
    public static boolean debug = false;

    public static void main(String[] args) throws IOException {
        if(Arrays.toString(args).contains("-debug")){
            debug = true;
            System.out.println("Debug mode activated.");
        }
        System.out.println(Arrays.toString(args));
        // write your code here
        MainWindow.create();

    }
}
