package me.meloni.UserGUI;

import me.meloni.FileReading.Values;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Used to write data into ".solarlog"-files
 *
 * @author ChaosMelone9
 *
 * @since 0.0.1
 */
public class Write {
    public Write(List<String> paths) {
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
            Map<String, List<Integer>> data = Values.DataMap(paths);
            me.meloni.DataStorage.Write.write(writepath, data);
            MainWindow.enableframe();
        } else {
            new Import();
        }
    }
}
