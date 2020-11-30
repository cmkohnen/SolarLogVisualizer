package me.meloni.SolarLogVisualizer.UI;

import Handling.SolarMap;
import Interface.BasicUI.GraphCustomizer;

import javax.swing.*;
import java.awt.*;

public class Visualizer extends JFrame {
    public Visualizer() {
        super("Visualization");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setupComponents();
        setLocationRelativeTo(null);
        pack();
        setSize(1000,800);
        setVisible(true);
    }

    public void setupComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel header = new JPanel();
        header.setBackground(new Color(255,0,0));
        c.weighty = 0;
        c.ipady = 40;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 0;
        add(header, c);

        JTabbedPane options = new Options();
        options.setBackground(new Color(0,255,0));
        c.weighty = 1;
        c.ipadx = 250;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(options, c);

        JPanel graph = new JPanel();
        graph.setBackground(new Color(0,0,255));
        c.weightx = 0.8;
        c.gridx = 1;
        c.gridy = 1;
        add(graph, c);
    }
}
