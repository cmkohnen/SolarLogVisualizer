package me.meloni.UserGUI;

import me.meloni.FileReading.Validate;
import me.meloni.Tools.Nord;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Import {
    private static List<String> paths = new ArrayList<>();
    private static JPanel l = new JPanel();
    private static JButton next = new JButton();
    private static File path = FileSystemView.getFileSystemView().getHomeDirectory();
    public Import(){



        JFrame frame = new JFrame("Visualizer - Import");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //l.setBounds(160,140,200,300);
        l.setBackground(new Color(59, 66, 82));


        JLabel adddirlabel = new JLabel();
        adddirlabel.setFont(new Font("Courier", Font.PLAIN, 20));
        adddirlabel.setForeground(Nord.n6());
        adddirlabel.setText("Add Directory");
        JButton adddir = new JButton();
        adddir.add(adddirlabel);
        adddir.setBounds(100,410,300,30);
        adddir.setBackground(Nord.n10());
        adddir.addActionListener(e ->{
            JFileChooser j = new JFileChooser(path);
            j.setDialogTitle("Import");
            j.setAcceptAllFileFilterUsed(false);
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if(j.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                List<File> addpaths = Arrays.asList(Objects.requireNonNull(j.getSelectedFile().listFiles()));
                path = j.getSelectedFile().getParentFile();
                addpaths.forEach(f->{
                    if(f.getName().contains(".dat")){
                        try {
                            if(Validate.validate(f.getPath())){
                                addpath(f.getPath());
                                //System.out.println(f);
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                });
            }
        });



        JLabel addmorelabel = new JLabel();
        addmorelabel.setFont(new Font("Courier", Font.PLAIN, 20));
        addmorelabel.setForeground(Nord.n6());
        addmorelabel.setText("Add more");
        JButton addmore = new JButton();
        addmore.add(addmorelabel);
        addmore.setBounds(100,445,300,30);
        addmore.setBackground(Nord.n10());
        addmore.addActionListener(e -> {
            JFileChooser j = new JFileChooser(path);

            // invoke the showsSaveDialog function to show the save dialog
            j.setDialogTitle("Import");
            j.setAcceptAllFileFilterUsed(false);
            j.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    if(f.isDirectory()) {return true;}
                    if(f.getName().contains(".dat")){
                        try {
                            return Validate.validate(f.getPath());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } return false;
                }

                @Override
                public String getDescription() {
                    return "Data files (*.dat)";
                }
            });
            int r = j.showOpenDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION){
                addpath(j.getSelectedFile().getPath());
            }

        });
        frame.add(addmore);

        JLabel listind = new JLabel();
        listind.setBounds(100,110,200,25);
        listind.setFont(new Font("Courier", Font.PLAIN, 20));
        listind.setForeground(Nord.n6());
        listind.setText("Importing from:");
        frame.add(listind);

        l.setLayout(new BoxLayout(l, BoxLayout.Y_AXIS));



        JLabel nextlabel = new JLabel();
        nextlabel.setFont(new Font("Courier", Font.PLAIN, 20));
        nextlabel.setForeground(Nord.n6());
        nextlabel.setText("Next");
        next.add(nextlabel);
        next.setBounds(750,495,140,30);
        next.setBackground(Nord.n14());
        next.setEnabled(paths.size() >= 1);
        next.addActionListener(e->{
            if(next.isEnabled()){
                frame.setVisible(false);
                try {
                    new Write(paths);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JLabel homelabel = new JLabel();
        homelabel.setFont(new Font("Courier", Font.PLAIN, 20));
        homelabel.setForeground(Nord.n6());
        homelabel.setText("Back");
        JButton home = new JButton();
        home.add(homelabel);
        home.setBounds(590,495,140,30);
        home.setBackground(Nord.n14());
        home.addActionListener(e ->{
            MainWindow.enableframe();
            frame.setVisible(false);
        });

        JTextPane t = new JTextPane();
        t.setBounds(470,140,420,335);
        t.setEditable(false);
        t.setFont(new Font("Courier", Font.PLAIN, 20));
        t.setForeground(Nord.n6());
        t.setBackground(Nord.n2());
        t.setText("Please specify where you want to import your Data from. \nAs this project ist Work In Progress, you can only import in the specific format.\n\nClick \"Next\" when specified all locations.");

        JPanel text = new JPanel();
        text.setBackground(Nord.n2());

        frame.add(MainWindow.header());

        JScrollPane p = new JScrollPane(l);
        p.setBounds(100,140,300,265);

        JScrollBar s1 = new JScrollBar();
        s1.setBackground(Nord.n1());
        p.setVerticalScrollBar(s1);


        frame.add(p);
        frame.add(next);
        frame.add(home);
        frame.add(t);
        frame.add(adddir);

        frame.add(text);
        frame.setBackground(new Color(76, 86, 106, 255));
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




    }
    private static void addpath(String spath){
        if(!paths.contains(spath)){
            paths.add(spath);
        }
        //System.out.println(paths);
        l.removeAll();
        for (String p : paths) {
            JLabel m = new JLabel();
            m.setText(p);
            m.setForeground(Nord.n7());
            m.setFont(new Font("Courier", Font.PLAIN, 18));
            l.add(m);
        }

        path = new File(spath).getParentFile();
        l.setVisible(false);
        l.setVisible(true);
        next.setEnabled(true);

    }


}


