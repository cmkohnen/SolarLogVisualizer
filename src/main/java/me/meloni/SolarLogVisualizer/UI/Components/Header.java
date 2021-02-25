package me.meloni.SolarLogVisualizer.UI.Components;

import me.meloni.SolarLogVisualizer.Config.Colors;
import me.meloni.SolarLogVisualizer.UI.Popups.SaveOptions;
import me.meloni.SolarLogVisualizer.UI.Popups.SolarMapCustomizer;
import me.meloni.SolarLogVisualizer.UI.Visualizer;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    Visualizer instance;
    public Header(Visualizer instance) {
        this.instance = instance;

        setBackground(Colors.backgroundColor);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.weighty = 1;
        c.gridy = 0;

        JLabel label = new JLabel("SolarLogVisualizer v2");
        label.setFont(label.getFont().deriveFont(Font.BOLD, 30f));
        label.setForeground(Colors.fontColor);
        c.weightx = 0.3;
        add(label, c);

        SolarMapCustomizer solarMapCustomizer = new SolarMapCustomizer(instance);

        JButton button1 = new JButton();
        button1.setBackground(Colors.buttonColor);
        JLabel button1Label = new JLabel("Import");
        button1Label.setFont(new Font("Courier", Font.PLAIN, 30));
        button1Label.setForeground(Colors.fontColor);
        button1.add(button1Label);
        button1.addActionListener(actionEvent -> solarMapCustomizer.setVisible(true));
        add(button1, c);

        SaveOptions saveOptions = new SaveOptions(instance);

        JButton button2 = new JButton();
        button2.setBackground(Colors.buttonColor);
        JLabel button2Label = new JLabel("Save");
        button2Label.setFont(new Font("Courier", Font.PLAIN, 30));
        button2Label.setForeground(Colors.fontColor);
        button2.add(button2Label);
        button2.addActionListener(actionEvent -> saveOptions.setVisible(true));
        add(button2, c);

    }


}
