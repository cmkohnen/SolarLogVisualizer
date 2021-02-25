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
package me.meloni.SolarLogVisualizer.UI;

import me.meloni.SolarLogAPI.SolarMap;
import me.meloni.SolarLogVisualizer.Config.Colors;
import me.meloni.SolarLogVisualizer.UI.Components.Header;
import me.meloni.SolarLogVisualizer.UI.Components.Options;

import javax.swing.*;
import java.awt.*;

public class Visualizer extends JPanel {
    MainWindow instance;
    private final SolarMap solarMap;
    private JPanel graph;
    private final GridBagConstraints c = new GridBagConstraints();
    public Visualizer(MainWindow mainWindow) {
        this.instance = mainWindow;
        this.solarMap = new SolarMap();
        setLayout(new GridBagLayout());
        setupComponents();
        setBackground(Colors.backgroundColor);
    }

    public void setupComponents() {
        c.fill = GridBagConstraints.BOTH;

        JPanel header = new Header(this);
        //header.setBackground(new Color(255,0,0));
        c.weighty = 0;
        c.ipady = 40;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 0;
        add(header, c);

        Options options = new Options();
        //options.setBackground(new Color(0,255,0));
        c.weighty = 1;
        c.ipadx = 120;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(options, c);

        this.graph = new JPanel();
        graph.setBackground(Colors.backgroundColor);
        c.weightx = 0.8;
        c.gridx = 1;
        c.gridy = 1;
        add(graph, c);

        options.initialize(this);
    }

    public SolarMap getSolarMap() {
        return solarMap;
    }

    public void setGraph(JPanel newGraph) {
        remove(this.graph);
        this.graph = newGraph;
        c.weightx = 0.8;
        c.gridx = 1;
        c.gridy = 1;
        add(graph, c);
        repaint();
        instance.remove(this);
        instance.add(this);
        instance.repaint();
        instance.setVisible(true);
        setVisible(true);
    }

    public void setDate(String date) {
        instance.setTitle("Visualize - " + date);
    }

}
