package me.meloni.UserGUI;

import me.meloni.DataStorage.Read;
import me.meloni.DataStorage.Write;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

public class Visualize {
    public static void visualize() throws IOException {

        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

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
            System.out.println(Read.Data(readpath));
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
    }
}
