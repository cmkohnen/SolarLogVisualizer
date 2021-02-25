package me.meloni.SolarLogVisualizer.UI;

import me.meloni.SolarLogVisualizer.Config.Colors;
import me.meloni.SolarLogVisualizer.Config.Values;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private static final int minHeight = Values.MINHEIGHT;
    private static final int minWidth = Values.MINWIDTH;
    private final Visualizer content;
    private final JPanel blank;
    private boolean tooSmall;

    public MainWindow() {
        this.content = new Visualizer(this);
        this.blank = new JPanel();
        setupFrame();
        setupComponents();
        addComponents();
        setupEvents();
        setVisible(true);
    }

    private void setupFrame() {
        setTitle("Visualization");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000,800);
        setBackground(Colors.backgroundColor);
    }

    private void setupComponents() {
        JLabel label = new JLabel();
        label.setText("Too small!");
        blank.add(label);
    }

    private void addComponents() {
        add(content);
    }

    private void setupEvents() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int width = e.getComponent().getWidth();
                int height = e.getComponent().getHeight();

                if(tooSmall != width < minWidth || height < minHeight) {
                    tooSmall = width < minWidth || height < minHeight;
                    if(tooSmall) {
                        remove(content);
                        add(blank);
                    } else {
                        remove(blank);
                        add(content);
                    }
                }
            }
        });
    }

    @Override
    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            me.meloni.SolarLogVisualizer.Visualizer.exit("Window closed.");
            dispose();
        }
    }
}
