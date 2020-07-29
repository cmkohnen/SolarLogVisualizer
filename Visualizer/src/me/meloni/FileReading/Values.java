package me.meloni.FileReading;

import me.meloni.Tools.DateConverter;

import java.io.IOException;
import java.util.*;

public class Values {

    /*
    Positions of values in List<String> format
        Verbrauch W: 6
        Verbrauch kWh: 10
        Leistung W: 17
        Ertrag KWh: 23
        Eigenverbrauch W: 44
     */

    public static List<String> Wertereihe(int pos, String path) throws IOException{
        List<String> mindata = Reader.mindata(path);
        String content = mindata.get(pos - 1);
        String[] str = content.split(";");
        return Arrays.asList(str);
    }

    public static Map<String, List<Integer>> DataMap(List<String> paths) throws IOException {
        Map<String, List<Integer>> Data = new HashMap<>();
        paths.forEach(path->{
            List<String> mindata = null;
            try {
                mindata = Reader.mindata(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert mindata != null;
            mindata.forEach(item->{
            String[] str = item.split(";");
            List<String> values = Arrays.asList(str);

            //intitialize variables
            int verbrauchw = 0;
            int verbrauchkwh = 0;
            int leistungw = 0;
            int ertragkwh = 0;
            int energieverbrauchw = 0;

            List<Integer> valueseach = new ArrayList<>();

            String timestamp = DateConverter.Timestamp(values.get(2));

            //getting values
            verbrauchw = Integer.parseInt(values.get(6));
            verbrauchkwh = Integer.parseInt(values.get(10));
            leistungw = Integer.parseInt(values.get(17));
            ertragkwh = Integer.parseInt(values.get(23));
            energieverbrauchw = Integer.parseInt(values.get(44));


            //writing values to List
            valueseach.add(verbrauchw);
            valueseach.add(verbrauchkwh);
            valueseach.add(leistungw);
            valueseach.add(ertragkwh);
            valueseach.add(energieverbrauchw);


            //Writing List to Map
            Data.put(timestamp, valueseach);

            //System.out.println(DateConverter.Timestamp(values.get(2)) + " Verbrauch: " + verbrauch);
        });
        });
        return Data;
    }
}
