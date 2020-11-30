package me.meloni.SolarLogVisualizer.UI;

import Handling.SolarMap;

import javax.swing.*;

public class Options extends JTabbedPane {
    public void initialize(Visualizer instance) {
        addTab("Day View", new DayView(instance));
        addTab("Month View", new MonthView(instance));
    }
}
