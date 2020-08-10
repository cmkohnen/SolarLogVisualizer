package me.meloni.DataStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;

/**
 * Class for reading the ".solarlog"-files. The Map-function Data(String path) represents the written data on the file specified in path.
 *
 * @author ChaosMelone9
 *
 * @since 0.0.2
 */
public class Read {
    /**
     * represents the written data on the file specified in path.
     *
     * @since 0.0.2
     */
    public static Map<String, List<Integer>> Data(String path) {
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