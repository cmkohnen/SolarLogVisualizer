package me.meloni.DataStorage;

import me.meloni.FileReading.Values;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class Write {
    public static void write(String writepath, String readpath) throws IOException {
        Map<String, Integer> fileObj = Values.Verbrauchasmap(readpath);


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
