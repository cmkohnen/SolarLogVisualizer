package me.meloni.SolarLogVisualizer.UI.Popups;

import me.meloni.SolarLogAPI.BasicGUI.GetChosenFile;
import me.meloni.SolarLogAPI.FileInteraction.GetFile;
import me.meloni.SolarLogAPI.SolarMap;
import me.meloni.SolarLogVisualizer.UI.Visualizer;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class SolarMapCustomizer {
    private final JFrame f;

    public SolarMapCustomizer(Visualizer instance) {
        SolarMap solarMap = instance.getSolarMap();
        JFrame frame = new JFrame();
        JPanel buttons = new JPanel();
        frame.setLocationRelativeTo(instance);

        JButton addFile = new JButton("Add File");
        addFile.addActionListener(e -> {
            File f = GetChosenFile.chosenDatFile();
            if (!(f == null) && f.exists()) {
                try {
                    solarMap.addFromDatFile(f);
                    setVisible(false);
                } catch (IOException | ParseException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JButton addDirectory = new JButton("Add from Folder");
        addDirectory.addActionListener(e -> {
            try {
                List<File> files = GetChosenFile.chosenDatFilesInDirectory();
                if (!(files == null)) {
                    solarMap.addFromDatFiles(files);
                    setVisible(false);
                }
            } catch (IOException | ParseException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton addTar = new JButton("Add from tar");
        addTar.addActionListener(e -> {
            File f = GetChosenFile.chosenTarArchive();
            if (!(f == null) && f.exists()) {
                try {
                    solarMap.addFromTarArchive(f);
                    setVisible(false);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        JButton addTars = new JButton("Add from tars");
        addTars.addActionListener(e -> {
            try {
                List<File> files = GetChosenFile.chosenTarArchivesInDirectory();
                if (!(files == null)) {
                    solarMap.addFromTarArchives(files);
                    setVisible(false);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        JButton addDataFile = new JButton("Add from Data File");
        addDataFile.addActionListener(e -> {
            File f = GetChosenFile.chosenSolarLogFile();
            if (!(f == null) && f.exists()) {
                try {
                    solarMap.addFromSolarLogFile(f);
                    setVisible(false);
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        buttons.add(addFile);
        buttons.add(addDirectory);
        buttons.add(addTar);
        buttons.add(addTars);
        buttons.add(addDataFile);
        frame.add(buttons);
        frame.setSize(200, 600);
        f = frame;
    }

    public void setVisible(boolean visible) {
        f.setVisible(visible);
    }
}
