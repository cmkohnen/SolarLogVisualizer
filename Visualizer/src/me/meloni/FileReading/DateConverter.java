package me.meloni.FileReading;

public class DateConverter {
    public static String Timestamp(String date){

        //Original Format: DAY.MONTH.YEAR HOURS:MINUTES:SECONDS
        //My Format:       YEAR/MONTH/DAY/HOURS/MINUTES/SECONDS


        return date.substring(6, 8) + date.substring(3, 5) + date.substring(0, 2) +
                date.substring(9, 11) + date.substring(12, 14) + "00";

    }






}
