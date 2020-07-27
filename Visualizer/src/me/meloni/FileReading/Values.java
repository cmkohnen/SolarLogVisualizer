package me.meloni.FileReading;

import java.io.IOException;
import java.util.*;

public class Values {

    public static List<Integer> Verbrauchaslist() throws IOException {
        List<String> mindata = Reader.mindata();
        List<Integer> Verbrauch = new ArrayList();

        /*for(int i = 1; i < mindata.size(); i++){
            Verbrauch.add(Integer.getInteger(Wertereihe(i).get(6)));
            System.out.println(Wertereihe(i).get(2) + " Verbrauch: " + Wertereihe(i).get(6));
        }*/

        mindata.forEach(item->{
            String[] str = item.split(";");
            List<String> values = Arrays.asList(str);
            int verbrauch;
            try {
                verbrauch = Integer.parseInt(values.get(6));
            }
            catch (NumberFormatException e)
            {
                verbrauch = 0;
            }
            Verbrauch.add(verbrauch);
            System.out.println(values.get(2) + " Verbrauch: " + verbrauch);
        });






        return Verbrauch;
    }

    public static Map<String, Integer> Verbrauchasmap() throws IOException{
        List<String> mindata = Reader.mindata();
        Map<String, Integer> Verbrauch = new HashMap<>();

        /*for(int i = 1; i < mindata.size(); i++){
            Verbrauch.add(Integer.getInteger(Wertereihe(i).get(6)));
            System.out.println(Wertereihe(i).get(2) + " Verbrauch: " + Wertereihe(i).get(6));
        }*/

        mindata.forEach(item->{
            String[] str = item.split(";");
            List<String> values = Arrays.asList(str);
            int verbrauch;
            try {
                verbrauch = Integer.parseInt(values.get(6));
            }
            catch (NumberFormatException e)
            {
                verbrauch = 0;
            }
            Verbrauch.put(DateConverter.Timestamp(values.get(2)), verbrauch);
            System.out.println(DateConverter.Timestamp(values.get(2)) + " Verbrauch: " + verbrauch);
        });
        return Verbrauch;
    }

    public static List<String> Wertereihe(int pos) throws IOException{
        List<String> mindata = Reader.mindata();
        String content = mindata.get(pos - 1);
        String[] str = content.split(";");
        return Arrays.asList(str);
    }

}
