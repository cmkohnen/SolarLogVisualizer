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
import me.meloni.SolarLogAPI.DatabaseInteraction.SQLDatabase;
import me.meloni.SolarLogAPI.Handling.Logger;
import me.meloni.SolarLogAPI.SolarMap;
import me.meloni.SolarLogVisualizer.UI.Visualizer;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class SaveOptions extends JFrame {

    public SaveOptions(Visualizer instance) {
        SolarMap solarMap = instance.getSolarMap();
        JPanel buttons = new JPanel();
        setLocationRelativeTo(instance);
        setSize(200, 600);

        JButton writeToFile = new JButton("Write to file");
        writeToFile.addActionListener(actionEvent -> {

            try {
                File f = GetChosenFile.chosenSaveLocation();
                if(f != null) {
                    solarMap.writeToSolarLogFile(f);
                }
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        });

        JButton writeToInfluxDB = new JButton("Write to InfluxDB");
        writeToInfluxDB.addActionListener(actionEvent -> {
            try {
                solarMap.writeToInfluxDBDataBase(GetDatabase.influxDatabase().getInfluxDB(), 125000);
            } catch (NullPointerException e) {
                Logger.warn(Logger.INFO_LEVEL_3 + "Database incorrect.");
            }
        });

        JButton writeToSQL = new JButton("Write to SQL");
        writeToSQL.addActionListener(actionEvent -> {
            SQLDatabase sqlDatabase = GetDatabase.SQLDatabase();
            try {
                assert sqlDatabase != null;
                solarMap.writeToMySQLDatabase(sqlDatabase.getHost(), sqlDatabase.getUser(), sqlDatabase.getPassword(), sqlDatabase.getDatabase(), sqlDatabase.getTable());
            } catch (NullPointerException | SQLException e) {
                Logger.warn(Logger.INFO_LEVEL_3 + "Unable to write to database");
            }
        });

        buttons.add(writeToFile);
        buttons.add(writeToInfluxDB);
        buttons.add(writeToSQL);
        add(buttons);
    }

}
