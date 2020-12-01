package me.meloni.SolarLogVisualizer.UI.Components;

import me.meloni.SolarLogVisualizer.Config.Colors;
import me.meloni.SolarLogVisualizer.UI.Visualizer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Options extends JTabbedPane {
    public void initialize(Visualizer instance) {
        addTab("Day View", new DayView(instance));
        addTab("Month View", new MonthView(instance));
        setBackground(Colors.optionsColor);
    }
}
