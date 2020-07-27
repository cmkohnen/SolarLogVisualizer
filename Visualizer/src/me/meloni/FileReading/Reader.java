package me.meloni.FileReading;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Reader {
    static String path = "E:\\test\\backup_data_19.07.20.dat";



    public static String WholeContent() throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static String usefullinfo() throws  IOException{
        List<String> list = alllines();

        return list.get(0);
    }


    public static List<String> alllines() throws IOException {
        String content = WholeContent();
        String[] str = content.split("\n");
        List<String> al;
        al = Arrays.asList(str);

        return al;
    }
}
