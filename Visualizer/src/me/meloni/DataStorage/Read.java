package me.meloni.DataStorage;

import me.meloni.FileReading.Values;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Read {
    public static Map<String, Integer> readVerbrauch(String path) throws IOException {


        try {
            File file = new File(path);
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream s = new ObjectInputStream(f);
            Map<String, Integer> map = (Map<String, Integer>) s.readObject();
            s.close();
            return map;
        }
        catch (IOException | ClassNotFoundException ioe){
            ioe.printStackTrace();
            return null;
        }

    }
}