package me.meloni.UserGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow extends JFrame {
         public static void create() {
            JFrame frame = new JFrame("Solar Log Visualizer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            createUI(frame);
            frame.setSize(560, 450);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        private static void createUI(JFrame frame){
            JPanel panel = new JPanel();
            LayoutManager layout = new FlowLayout();
            panel.setLayout(layout);

            JEditorPane jEditorPane = new JEditorPane();
            jEditorPane.setEditable(false);



            JButton b1 = new JButton("import");
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Read.read();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            });


            panel.add(b1);




            JButton b2 = new JButton("visualize");
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Visualize.visualize();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            });


            panel.add(b2);

            //JScrollPane jScrollPane = new JScrollPane(jEditorPane);
            //jScrollPane.setPreferredSize(new Dimension(540,400));

            //panel.add(jScrollPane);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
        }
}


