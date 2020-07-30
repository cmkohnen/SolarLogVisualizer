package me.meloni.UserGUI;

import me.meloni.Visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow extends JFrame {
    private static final int width = 1000;
    private static final int height = 600;

    private static JFrame frame = new JFrame("Visualizer - Home");

    public static void enableframe(){
        frame.setVisible(true);
    }
    public static void disableframe(){

    }

    public static JPanel header(Integer width){
        JPanel header = new JPanel();
        header.setBackground(new Color(46, 52, 64, 255));
        header.setBounds(0, 0,width,40);

        JLabel headstring = new JLabel();
        headstring.setBounds(30,20,200,10);
        headstring.setText("Solarlog Visualizer by ChaosMelone9");
        headstring.setForeground(new Color(236, 239, 244, 255));
        headstring.setFont(new Font("Courier", Font.PLAIN, 20));
        header.add(headstring);

        JLabel version = new JLabel("Version " + Visualizer.version);
        version.setForeground(new Color(216, 222, 233, 255));
        header.add(version);

        return header;
    }

         public static void create() {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





            JPanel body = new JPanel();
             body.setBackground(new Color(76, 86, 106, 255));
             body.setBounds(0, 40,width,560);

             JLabel visualizelabel = new JLabel();
             visualizelabel.setText("Visualize");
             visualizelabel.setForeground(new Color(236, 239, 244, 255));
             visualizelabel.setFont(new Font("Courier", Font.PLAIN, 80));
            JButton visualize = new JButton();
            visualize.add(visualizelabel);
            visualize.setBounds(200, 140, 600, 100);
            visualize.setBackground(new Color(143, 188, 187, 255));
            visualize.addActionListener(e -> {
                try {
                    Visualize.visualize();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            frame.add(visualize);


             JLabel importerlabel = new JLabel();
             importerlabel.setText("Import");
             importerlabel.setForeground(new Color(236, 239, 244, 255));
             importerlabel.setFont(new Font("Courier", Font.PLAIN, 80));
             JButton importer = new JButton();
             importer.add(importerlabel);
             importer.setBounds(200, 320, 600, 100);
             importer.setBackground(new Color(94, 129, 172, 255));
             importer.addActionListener(e -> {


                    frame.setVisible(false);
                    new Import();

                 /*try {
                     Read.read();
                 } catch (IOException ioException) {
                     ioException.printStackTrace();
                 }

                  */
             });
             frame.add(importer);


            frame.add(body);
            frame.add(header(1000));



            frame.setSize(width, height);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

}


