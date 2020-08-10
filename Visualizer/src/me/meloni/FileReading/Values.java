package me.meloni.FileReading;

import me.meloni.Tools.DateConverter;

import java.io.IOException;
import java.util.*;
/**
 * Class for converting backup files into usable data.
 *
 * @author ChaosMelone9
 *
 * @since 0.0.1
 */
public class Values {

    /*
    Positions of values in List<String> format
        Verbrauch W: 6
        Verbrauch kWh: 10
        Leistung W: 17
        Ertrag KWh: 23
        Eigenverbrauch W: 44
     */



    /**
     * Represents a Map of data based on a list of filepaths. This method actually converts data from backup files into usable and more lightweight data.
     *
     * @since 0.0.1
     */
    public static Map<String, List<Integer>> DataMap(List<String> paths) {
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
            int verbrauchw;
            int verbrauchkwh;
            int leistungw;
            int ertragkwh;
            int energieverbrauchw;

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
        });
        });
        return Data;
    }
}
