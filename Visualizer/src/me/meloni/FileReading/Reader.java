package me.meloni.FileReading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Reader {
    //static String path = "E:\\test\\backup_data_22.07.20.dat";



    public static String WholeContent(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static String usefullinfo(String path) throws  IOException{
        String base = alllines(path).get(0);

        StringBuilder info = new StringBuilder();
        info.append("Model name: ");

        StringBuilder modelname = new StringBuilder();
        for(int i = 2; !String.valueOf(base.charAt(i)).equals(" "); i ++){
            modelname.append(base.charAt(i));
        }
        info.append(modelname).append(" ");



        return info.toString();
    }

    public static List<String> mindata(String path) throws IOException {
        List<String> lines = alllines(path);
        List<String> mindata = new ArrayList<>(Collections.singletonList(""));
        for(int i = 55; i < 9271; i++) {
            mindata.add(lines.get(i));
        }
        mindata.remove("");
        return mindata;
    }



    public static List<String> alllines(String path) throws IOException {
        String content = WholeContent(path);
        String[] str = content.split("\n");
        List<String> al;
        al = Arrays.asList(str);

        return al;
    }
}
