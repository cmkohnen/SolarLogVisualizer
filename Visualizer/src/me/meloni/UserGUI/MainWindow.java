package me.meloni.UserGUI;

import me.meloni.Visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    public static void createwindow() {
        //Create and set up the window.
        JFrame frame = new JFrame("Solar Log Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel textLabel = new JLabel("Vizualizer v" + Visualizer.version,SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.NORTH);

        /*JButton button = new JButton();
        frame.add(button, BorderLayout.CENTER);
        button.add(textLabel);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText("EditLabelSuccessfull");
            }
        });*/

        //Display the window.
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }






}
