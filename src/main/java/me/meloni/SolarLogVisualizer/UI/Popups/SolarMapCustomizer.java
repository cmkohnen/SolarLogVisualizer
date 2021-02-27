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
import me.meloni.SolarLogAPI.BasicGUI.GetDatabase;
import me.meloni.SolarLogAPI.BasicGUI.ImportFromFTP;
import me.meloni.SolarLogAPI.DatabaseInteraction.InfluxDatabase;
import me.meloni.SolarLogAPI.Handling.Logger;
import me.meloni.SolarLogAPI.SolarMap;
import me.meloni.SolarLogVisualizer.UI.VisualizerPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SolarMapCustomizer extends JDialog {

    public SolarMapCustomizer(VisualizerPanel instance) {
        SolarMap solarMap = instance.getSolarMap();
        JPanel buttons = new JPanel();
        setLocationRelativeTo(instance);
        setSize(200, 600);

        JButton addDatFile = new JButton("Add .dat-file");
        addDatFile.addActionListener(e -> {
            File f = GetChosenFile.chosenDatFile();
            if(!(f == null) && f.exists()) {
                try {
                    solarMap.addFromDatFile(f);
                } catch (IOException ioException) {
                    Logger.warn(ioException.getMessage());
                }
                setVisible(false);
            }
        });

        JButton addDatFiles = new JButton("Add .dat-files");
        addDatFiles.addActionListener(e -> {
            List<File> files = GetChosenFile.chosenDatFilesInDirectory();
            if(!(files == null)) {
                solarMap.addFromDatFiles(files);
                setVisible(false);
            }
        });

        JButton addTarArchive = new JButton("Add tar archive");
        addTarArchive.addActionListener(e -> {
            File f = GetChosenFile.chosenTarArchive();
            if(!(f == null) && f.exists()) {
                try {
                    solarMap.addFromTarArchive(f);
                } catch (Exception exception) {
                    Logger.warn(exception.getMessage());
                }
                setVisible(false);
            }
        });

        JButton addTarArchives = new JButton("Add tar archives");
        addTarArchives.addActionListener(e -> {
            try {
                List<File> files = GetChosenFile.chosenTarArchivesInDirectory();
                if(!(files == null)) {
                    solarMap.addFromTarArchives(files);
                    setVisible(false);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            setVisible(false);
        });

        JButton addSolarLogFile = new JButton("Add data file");
        addSolarLogFile.addActionListener(e -> {
            File f = GetChosenFile.chosenSolarLogFile();
            if(!(f == null) && f.exists()) {
                try {
                    solarMap.addFromSolarLogFile(f);
                } catch (IOException ioException) {
                    Logger.warn(ioException.getMessage());
                }
                setVisible(false);
            }
        });

        JButton addEMLFile = new JButton("Add .eml-file");
        addEMLFile.addActionListener(e -> {
            File f = GetChosenFile.chosenEMLFile();
            if(!(f == null) && f.exists()) {
                try {
                    solarMap.addFromEMLFile(f);
                } catch (Exception exception) {
                    Logger.warn(exception.getMessage());
                }
                setVisible(false);
            }
        });

        JButton addEMLFiles = new JButton("Add .eml-files");
        addEMLFiles.addActionListener(e -> {
            try {
                List<File> files = GetChosenFile.chosenEMLFilesInDirectory();
                if(!(files == null)) {
                    solarMap.addFromEMLFiles(files);
                    setVisible(false);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        JButton addInfluxDB = new JButton("Add InfluxDB");
        addInfluxDB.addActionListener(e -> {
            InfluxDatabase db = GetDatabase.influxDatabase();
            solarMap.addFromInfluxDB(db.getInfluxDB(), db.getDatabase());
            setVisible(false);
        });

        JButton addJSFile = new JButton("Add .js-file");
        addJSFile.addActionListener(e -> {
            File f = GetChosenFile.chosenJSFile();
            if(!(f == null) && f.exists()) {
                try {
                    solarMap.addFromJSFile(f);
                } catch (IOException ioException) {
                    Logger.warn(ioException.getMessage());
                }
                setVisible(false);
            }
        });

        JButton addJSFiles = new JButton("Add .js-files");
        addJSFiles.addActionListener(e -> {
            try {
                List<File> files = GetChosenFile.chosenJSFilesInDirectory();
                if(!(files == null)) {
                    solarMap.addFromJSFiles(files);
                    setVisible(false);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        JButton addFromFTP = new JButton("Add FTP-server");
        addFromFTP.addActionListener(e -> {
            try {
                solarMap.addFromSolarMap(ImportFromFTP.importWithGUI());
            } catch (IOException ioException) {
                Logger.warn(ioException.getMessage());
            }
            setVisible(false);
        });

        buttons.add(addDatFile);
        buttons.add(addDatFiles);
        buttons.add(addTarArchive);
        buttons.add(addTarArchives);
        buttons.add(addSolarLogFile);
        buttons.add(addEMLFile);
        buttons.add(addEMLFiles);
        buttons.add(addInfluxDB);
        buttons.add(addJSFile);
        buttons.add(addJSFiles);
        buttons.add(addFromFTP);
        add(buttons);
    }
}
