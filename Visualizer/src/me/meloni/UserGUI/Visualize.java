package me.meloni.UserGUI;

import me.meloni.Tools.Nord;
import me.meloni.UserGUI.Graphtemplates.Daily;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Visualize {


    public static void visualize() throws IOException {
        List<Double> scores = new ArrayList<>();
        Random random = new Random();
        int maxDataPoints = 40;
        int maxScore = 10;
        for (int i = 0; i < maxDataPoints; i++) {
            scores.add((double) random.nextDouble() * maxScore);
//            scores.add((double) i);
        }
        JComponent cmp = new Daily(scores);


        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 600);
        f.setTitle("Visualize - Graph");


        JPanel text = new JPanel();
        text.setBackground(Nord.n2());
        text.setBounds(300,40,2000,1000);




        JPanel s = new JPanel();
        s.setBackground(Nord.n1());
        s.setBounds(0,40,300,920);

        JPanel dp = new JPanel();
        dp.setBounds(10, 250, 270, 400);
        dp.setBackground(Nord.n2());

        






























        String[] types = {"", "Day view"};

        JTextPane desc = new JTextPane();
        desc.setBounds(10,50,270,160);
        desc.setText("Please select one of the following view types to display the information: daily, monthly, yearly.");
        desc.setFont(new Font("Courier", Font.PLAIN, 20));
        desc.setForeground(Nord.n6());
        desc.setBackground(Nord.n2());
        desc.setEditable(false);

        JComboBox type = new JComboBox(types);
        type.setSelectedIndex(0);
        type.setBounds(20,175,250,25);
        type.addActionListener(e->{
            JComboBox cb = (JComboBox)e.getSource();
            String str = (String)cb.getSelectedItem();

            assert str != null;
            if(str.equals("")){
                cmp.setVisible(false);
                text.setVisible(true);
                System.out.println("Test");
            }

            if(str.equals("Day view")){
                cmp.setVisible(true);
                text.setVisible(false);
                System.out.println("Test2");
            }









        });





        /*JButton b = new JButton("Text");
        b.setBounds(10,700,100,100);
        f.add(b);

         */


















        f.add(type);
        f.add(desc);
        f.add(dp);

        f.add(MainWindow.header(1600));
        f.add(s);
        f.add(text);
        f.add(cmp);

        cmp.setVisible(false);

        f.setBackground(new Color(76, 86, 106, 255));
        f.setSize(1600, 1000);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);










        /*JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // invoke the showsSaveDialog function to show the save dialog
        j.setDialogTitle("Import");
        j.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().contains(".solarlog") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Solarlog files (*.solarlog)";
            }
        });
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)

        {
            // set the label to the path of the selected file
            String readpath = j.getSelectedFile().getPath();
            //System.out.println(Read.Data(readpath));
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        GraphPanel.createAndShowGui(Read.Data(readpath));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


        }

         */
    }
}
