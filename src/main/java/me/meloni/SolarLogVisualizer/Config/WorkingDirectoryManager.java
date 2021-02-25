package me.meloni.SolarLogVisualizer.Config;

import me.meloni.SolarLogAPI.FileInteraction.WorkingDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class WorkingDirectoryManager {
    public static void createDirectory() throws IOException {
        File directory = new File(Paths.get("").toAbsolutePath().toString(), "Visualizer");
        if(!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Missing privileges");
        }
        WorkingDirectory.setDirectory(directory);
    }

    public static void removeDirectory() throws IOException {
        WorkingDirectory.clear();
        if(!WorkingDirectory.getDirectory().delete()) {
            throw new IOException("Missing privileges");
        }
    }
}
