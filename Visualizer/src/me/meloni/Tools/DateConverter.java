package me.meloni.Tools;

import java.util.ArrayList;
import java.util.List;

public class DateConverter {
    public static String Timestamp(String date){

        //Original Format: DAY.MONTH.YEAR HOURS:MINUTES:SECONDS
        //My Format:       YEAR/MONTH/DAY/HOURS/MINUTES/SECONDS


        return date.substring(6, 8) + date.substring(3, 5) + date.substring(0, 2) +
                date.substring(9, 11) + date.substring(12, 14) + "00";

    }

    
    public static List<String> Timestampsperday(String day){
        //Expected YEAR/MONTH/DAY
        List<String> list = new ArrayList<>();
        
        int min = 0;
        int hour = 0;
        
        for(int i = 0; i < 288; i++ ) {
            min = min + 5;
            if(min == 60) {
                hour++;
                min = 0;
            }



            
            StringBuilder timestamp = new StringBuilder();
            timestamp.append(day);
            if(String.valueOf(hour).length() == 1) {
                timestamp.append("0").append(hour);
            } else {
                timestamp.append(hour);
            }
            if(String.valueOf(min).length() == 1) {
                timestamp.append("0").append(min);
            } else {
                timestamp.append(min);
            }
            timestamp.append("00");

            //System.out.println(timestamp);
            list.add(timestamp.toString());
            
        }
        
        return list;
    }

    public static String dayfrompicker(String day){
        //From YEAR-MONTH-Day
        //To DAY/MONTH/YEAR
        return day.substring(2,4) + day.substring(5,7) + day.substring(8,10);
    }

    public static String day(String daystamp){
        //From YEAR/MONTH/DAY
        //To DAY.MONTH.YEAR
        return daystamp.substring(4,6) + "." + daystamp.substring(2,4) + "." + daystamp.substring(0,2);
    }

}
