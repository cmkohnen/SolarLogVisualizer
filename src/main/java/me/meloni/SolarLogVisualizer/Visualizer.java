package me.meloni.SolarLogVisualizer;

import me.meloni.SolarLogAPI.Handling.Logger;
import me.meloni.SolarLogVisualizer.UI.MainWindow;

public class Visualizer {
    public static void main(String[] args) {
        Logger.setEnabled(true);
        new MainWindow();
    }
}
