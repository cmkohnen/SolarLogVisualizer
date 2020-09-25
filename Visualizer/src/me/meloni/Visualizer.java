package me.meloni;

import me.meloni.UserGUI.MainWindow;

import java.util.Arrays;

/**
 * Main Visualizer Class
 *
 * @author ChaosMelone9
 *
 * @since 0.0.1
 */

public class Visualizer {
    /**
     * Specification of the fileversion used for ".solarlog"-files
     *
     * @since 0.0.5
     */
    public static final int fileversion = 1;
    /**
     * Main version
     *
     * @since 0.0.1
     */
    public static final String version = "0.1.2";
    /**
     * Wether or not debug is enabled
     *
     * @since 0.0.5
     */
    public static boolean debug = false;

    public static void main(String[] args) {
        // Main function called on startup

        //Enabling Debug
        if(Arrays.toString(args).contains("-debug")){
            debug = true;
            System.out.println("Debug mode activated.");
        }


        //Calling the Main Window
        MainWindow.create();

        //GraphPanel.createAndShowGui(Read.Data());

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



             */
        }
    }

