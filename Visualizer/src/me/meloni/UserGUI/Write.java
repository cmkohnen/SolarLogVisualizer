package me.meloni.UserGUI;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Write {
    public Write(List<String> paths) throws IOException {
        JFileChooser j2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        j2.setDialogTitle("Save");
        j2.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.canWrite() & f.getName().contains(".solarlog") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Solarlog files (*.solarlog)";
            }
        });
        int r2 = j2.showSaveDialog(null);

        if (r2 == JFileChooser.APPROVE_OPTION){
            String writepath = j2.getSelectedFile().getPath();

            if(!writepath.contains(".solarlog")){
                writepath = writepath + ".solarlog";
            }
            me.meloni.DataStorage.Write.write(writepath, paths);
            MainWindow.enableframe();
        } else {
            new Import();
        }






    }
}
