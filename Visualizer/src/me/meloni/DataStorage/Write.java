package me.meloni.DataStorage;

import me.meloni.FileReading.Values;
import me.meloni.Visualizer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Write {
    public static void write(String writepath, String readpath) throws IOException {
        Map<String, List<Integer>> fileObj = Values.DataMap(readpath);

        //Writing FileInfo
        List<Integer> version = new ArrayList<>();
        version.add(Visualizer.version);
        fileObj.put("version", version);


        try {
            File file = new File(writepath);
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(fileObj);
            s.flush();
            s.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
