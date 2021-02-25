package me.meloni.SolarLogVisualizer;

import me.meloni.SolarLogAPI.Handling.Logger;
import me.meloni.SolarLogVisualizer.Config.WorkingDirectoryManager;
import me.meloni.SolarLogVisualizer.UI.MainWindow;

import java.io.IOException;

public class Visualizer {
    public static void main(String[] args) {
        Logger.setEnabled(true);
        try {
            WorkingDirectoryManager.createDirectory();
            new MainWindow();
        } catch (IOException e) {
            exit(e.getMessage());
        }
    }

    public static void exit(String message) {
        try {
            WorkingDirectoryManager.removeDirectory();
        } catch (NullPointerException ignored) {

        } catch (IOException e) {
            Logger.warn("Unable to clear temporary storage!");
        }
        Logger.info(String.format("Visualizer exited: %s", message));
        System.exit(0);
    }
}
