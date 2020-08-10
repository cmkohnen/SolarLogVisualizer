package me.meloni.FileReading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Main Class for reading the files provided in weekly backups.
 *
 * @author ChaosMelone9
 *
 * @since 0.0.1
 */
public class Reader {
    /**
     * Represents the whole content of a file as a string.
     *
     * @since 0.0.1
     */
    public static String WholeContent(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
    /**
     * Represents the lines handling the data for every five minutes.
     *
     * @since 0.0.1
     */
    public static List<String> mindata(String path) throws IOException {
        List<String> lines = alllines(path);
        List<String> mindata = new ArrayList<>(Collections.singletonList(""));
        for(int i = 55; i < 9271; i++) {
            mindata.add(lines.get(i));
        }
        mindata.remove("");
        return mindata;
    }
    /**
     * Represents the context of an file as a list.
     *
     * @since 0.0.1
     */
    public static List<String> alllines(String path) throws IOException {
        String content = WholeContent(path);
        String[] str = content.split("\n");
        List<String> al;
        al = Arrays.asList(str);

        return al;
    }
}
