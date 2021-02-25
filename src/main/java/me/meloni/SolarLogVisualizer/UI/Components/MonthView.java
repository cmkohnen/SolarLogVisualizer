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

import me.meloni.SolarLogAPI.BasicGUI.Components.MonthPicker;
import me.meloni.SolarLogAPI.SolarMap;
import me.meloni.SolarLogVisualizer.Config.Colors;
import me.meloni.SolarLogVisualizer.UI.Visualizer;

import javax.swing.*;
import java.awt.*;
import java.time.YearMonth;

public class MonthView extends JPanel {
    private me.meloni.SolarLogAPI.BasicGUI.Components.Graph.MonthView graph = null;
    private final Visualizer instance;

    public MonthView(Visualizer instance) {
        this.instance = instance;
        SolarMap solarMap = instance.getSolarMap();
        setLayout(new BorderLayout());

        MonthPicker picker = new MonthPicker();
        picker.setMaximumSize(new Dimension(200,40));
        picker.addActionListener(actionEvent -> {
            YearMonth month = picker.getMonth();
            if(month != null && solarMap.includesMonth(month)) {
                graph = new me.meloni.SolarLogAPI.BasicGUI.Components.Graph.MonthView(solarMap, month);
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
        b1.setText("Row 1");
        b2.setText("Row 2");
        b3.setText("Row 3");
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
            graph.setRow1Visible(b1.isSelected());
            paintComponent();
        });
        b2.addActionListener(actionEvent -> {
            graph.setRow2Visible(b2.isSelected());
            paintComponent();
        });
        b3.addActionListener(actionEvent -> {
            graph.setRow3Visible(b3.isSelected());
            paintComponent();
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
            graph.setMouseGUIVisible(mouseGUI.isSelected());
            paintComponent();
        });
        p.add(mouseGUI);

        add(p,BorderLayout.WEST);
        setBackground(Colors.optionsColor);
    }

    public void paintComponent() {
        graph.setBackgroundColor(Colors.backgroundColor);
        instance.setGraph(graph);
    }
}
