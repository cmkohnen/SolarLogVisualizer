/*
Copyright 2020 - 2021 Christoph Kohnen
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package me.meloni.SolarLogVisualizer.UI.Popups;

import me.meloni.SolarLogAPI.BasicGUI.GetChosenFile;
import me.meloni.SolarLogAPI.BasicGUI.ImportFromFTP;
import me.meloni.SolarLogAPI.SolarMap;
import me.meloni.SolarLogVisualizer.UI.Visualizer;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SolarMapCustomizer extends JDialog {

    public SolarMapCustomizer(Visualizer instance) {
        SolarMap solarMap = instance.getSolarMap();
        JPanel buttons = new JPanel();
        setLocationRelativeTo(instance);
        setSize(200, 600);

        JButton addFile = new JButton("Add from Dat file");
        addFile.addActionListener(e -> {
            File f = GetChosenFile.chosenDatFile();
            if (!(f == null) && f.exists()) {
                try {
                    solarMap.addFromDatFile(f);
                    setVisible(false);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JButton addDirectory = new JButton("Add from Dat files");
        addDirectory.addActionListener(e -> {
            List<File> files = GetChosenFile.chosenDatFilesInDirectory();
            if (!(files == null)) {
                solarMap.addFromDatFiles(files);
                setVisible(false);
            }
        });

        JButton addTar = new JButton("Add from tar archive");
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

        JButton addTars = new JButton("Add from tar archives");
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
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JButton addFTPServer = new JButton("Add from FTP Server");
        addFTPServer.addActionListener(e -> {
            try {
                solarMap.addFromSolarMap(ImportFromFTP.importWithGUI());
                setVisible(false);
            } catch (IOException Exception) {
                Exception.printStackTrace();
            }
        });

        JButton addJSFiles = new JButton("Add from JS Files");
        addJSFiles.addActionListener(e -> {
            List<File> files = GetChosenFile.chosenJSFilesInDirectory();
            if (!(files == null)) {
                solarMap.addFromJSFiles(files);
                setVisible(false);
            }
        });

        buttons.add(addFile);
        buttons.add(addDirectory);
        buttons.add(addTar);
        buttons.add(addTars);
        buttons.add(addDataFile);
        buttons.add(addFTPServer);
        buttons.add(addJSFiles);
        add(buttons);
    }
}
