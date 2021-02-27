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
package me.meloni.SolarLogVisualizer.UI.Components;

import me.meloni.SolarLogAPI.BasicGUI.Components.YearPicker;
import me.meloni.SolarLogAPI.SolarMap;
import me.meloni.SolarLogVisualizer.Config.Colors;
import me.meloni.SolarLogVisualizer.UI.VisualizerPanel;

import javax.swing.*;
import java.awt.*;
import java.time.Year;

public class YearView extends JPanel {
    private me.meloni.SolarLogAPI.BasicGUI.Components.Graph.YearView graph = null;
    private final VisualizerPanel instance;

    public YearView(VisualizerPanel instance) {
        this.instance = instance;
        SolarMap solarMap = instance.getSolarMap();
        setLayout(new BorderLayout());

        YearPicker picker = new YearPicker();
        picker.setMaximumSize(new Dimension(200,40));
        picker.addActionListener(event -> {
            Year year = picker.getYear();
            if(year != null && solarMap.includesYear(year)) {
                graph = new me.meloni.SolarLogAPI.BasicGUI.Components.Graph.YearView(solarMap, year);
                paintComponent();
            }
        });
        picker.setBackground(Colors.optionsColor);

        add(picker, BorderLayout.PAGE_START);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));

        JCheckBox b1 = new JCheckBox();
        JCheckBox b2 = new JCheckBox();
        JCheckBox b3 = new JCheckBox();
        b1.setText("consumption");
        b2.setText("own consumption");
        b3.setText("production");
        b1.setSelected(true);
        b2.setSelected(true);
        b3.setSelected(true);
        b1.setBackground(Colors.optionsColor);
        b2.setBackground(Colors.optionsColor);
        b3.setBackground(Colors.optionsColor);
        b1.setForeground(Colors.fontColor);
        b2.setForeground(Colors.fontColor);
        b3.setForeground(Colors.fontColor);
        b1.addActionListener(actionEvent -> {
            try {
                graph.setRow1Visible(b1.isSelected());
                paintComponent();
            } catch (NullPointerException e) {
                b1.setSelected(!b1.isSelected());
            }
        });
        b2.addActionListener(actionEvent -> {
            try {
                graph.setRow2Visible(b2.isSelected());
                paintComponent();
            } catch (NullPointerException e) {
                b2.setSelected(!b2.isSelected());
            }
        });
        b3.addActionListener(actionEvent -> {
            try {
                graph.setRow3Visible(b3.isSelected());
                paintComponent();
            } catch (NullPointerException e) {
                b3.setSelected(!b3.isSelected());
            }
        });
        p.add(b1);
        p.add(b2);
        p.add(b3);

        p.setBackground(Colors.optionsColor);

        JCheckBox mouseGUI = new JCheckBox();
        mouseGUI.setText("MouseGUI");
        mouseGUI.setSelected(true);
        mouseGUI.setBackground(Colors.optionsColor);
        mouseGUI.setForeground(Colors.fontColor);
        mouseGUI.addActionListener(actionEvent -> {
            try {
                graph.setMouseGUIVisible(mouseGUI.isSelected());
                paintComponent();
            } catch (NullPointerException e) {
                mouseGUI.setSelected(!mouseGUI.isSelected());
            }
        });
        p.add(mouseGUI);

        add(p,BorderLayout.WEST);
        setBackground(Colors.optionsColor);
    }

    public void paintComponent() {
        graph.setBackgroundColor(Colors.backgroundColor);
        instance.setGraph(graph);
        instance.setTitle(graph.getTitle());
    }
}
