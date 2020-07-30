package me.meloni.FileReading;

import java.io.IOException;

public class Validate {
    public static boolean validate(String path) throws IOException {
        //System.out.println(Reader.alllines(path).get(1).startsWith("8;4"));
        //System.out.println(Reader.alllines(path));
        if(Reader.alllines(path).get(1).startsWith("8;4")){
            return true;
        } else {
            return false;
        }
    }
}
