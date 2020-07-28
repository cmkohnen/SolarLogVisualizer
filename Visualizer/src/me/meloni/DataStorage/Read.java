package me.meloni.DataStorage;

import me.meloni.FileReading.Values;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Read {
    public static Map<String, List<Integer>> Data(String path) throws IOException {


        try {
            File file = new File(path);
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream s = new ObjectInputStream(f);
            Object o = s.readObject();
            Map<String, List<Integer>> map = (Map<String, List<Integer>>) o;
            s.close();
            return map;
        }
        catch (IOException | ClassNotFoundException ioe){
            ioe.printStackTrace();
            return null;
        }

    }
}