package me.meloni.SolarLogVisualizer.UI;

import Handling.SolarMap;
import Interface.BasicUI.BasicSolarMapCustomizer;
import Interface.BasicUI.GraphCustomizer;

import javax.swing.*;
import java.awt.*;

public class Visualizer extends JFrame {
    private SolarMap solarMap;
    private JPanel graph;
    private final GridBagConstraints c = new GridBagConstraints();
    public Visualizer() {
        super("Visualization");
        this.solarMap = new SolarMap();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getSolarMapAsk();
        setupComponents();
        setLocationRelativeTo(null);
        pack();
        setSize(1000,800);
        setVisible(true);
    }

    public void setupComponents() {
        c.fill = GridBagConstraints.BOTH;

        JPanel header = new JPanel();
        header.setBackground(new Color(255,0,0));
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
        //graph.setBackground(new Color(0,0,255));
        c.weightx = 0.8;
        c.gridx = 1;
        c.gridy = 1;
        add(graph, c);

        options.initialize(this);
    }

    private void getSolarMapAsk() {
        this.solarMap = BasicSolarMapCustomizer.solarMap();
    }

    public JPanel getGraph() {
        return graph;
    }

    public SolarMap getSolarMap() {
        return solarMap;
    }

    public void setGraph(JPanel graph) {
        remove(this.graph);
        this.graph = graph;
        c.weightx = 0.8;
        c.gridx = 1;
        c.gridy = 1;
        add(graph, c);
        repaint();
        setVisible(true);
    }

    public void setDate(String date) {
        setTitle("Visualize - " + date);
    }

}
