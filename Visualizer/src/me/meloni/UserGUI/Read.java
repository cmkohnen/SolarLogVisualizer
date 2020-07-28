package me.meloni.UserGUI;

import me.meloni.DataStorage.Write;
import me.meloni.Visualizer;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Read implements ActionListener {
    Read()
    {
    }

    public static void read() throws IOException {
        JLabel l = new JLabel("Wähle eine Datei zum importieren aus!");
        // frame to contains GUI elements
        JFrame f = new JFrame("Import Data");

        // set the size of the frame
        f.setSize(400, 400);

        // set the frame's visibility
        f.setVisible(true);


        f.add(l);

// create an object of JFileChooser class
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // invoke the showsSaveDialog function to show the save dialog
        j.setDialogTitle("Import");
        j.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return false;
            }

            @Override
            public String getDescription() {
                return "*.dat";
            }
        });
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)

        {
            // set the label to the path of the selected file
            String readpath = j.getSelectedFile().getPath();
            l.setText("Opening file: " + readpath + "\nBitte wähle einen Speicherort aus!");

            JFileChooser j2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            j2.setDialogTitle("Save");
            j2.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.canWrite() || f.getName().contains(".solarlog");
                }

                @Override
                public String getDescription() {
                    return "*.solarlog";
                }
            });
            int r2 = j2.showSaveDialog(null);

            if (r2 == JFileChooser.APPROVE_OPTION){
                String writepath = j2.getSelectedFile().getPath();

                l.setText("Schreibe nach " + writepath);
                Write.write(writepath, readpath);
            } else {
                l.setText("Schreibvorgang abgebrochen!");
            }



        }
        // if the user cancelled the operation
        else {
            l.setText("Importvorgang abgebrochen!");
        }


        f.show();
    }
    public void actionPerformed(ActionEvent evt)
    {
        // if the user presses the save button show the save dialog
        String com = evt.getActionCommand();




    }


}
