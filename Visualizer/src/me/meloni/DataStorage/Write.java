package me.meloni.DataStorage;

import me.meloni.Visualizer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class for writing a Data to a ".solarlog"-file. The write(...) function writes given datamap into given path.
 *
 * @author ChaosMelone9
 *
 * @since 0.0.1
 */
public class Write {
    /**
     * writes given datamap into given path.
     *
     * @since 0.0.1
     */
    public static void write(String writepath, Map<String, List<Integer>> data) {

        //Writing FileInfo
        List<Integer> version = new ArrayList<>();
        version.add(Visualizer.fileversion);
        data.put("version", version);


        try {
            File file = new File(writepath);
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(data);
            s.flush();
            s.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
