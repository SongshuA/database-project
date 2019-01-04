package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateCreate {
    public static List<Timestamp> create(Integer beginYear, Integer beginMonth, Integer endYear, Integer endMonth){
        if(null == beginYear) beginYear = 999;
        if(null == beginMonth) beginMonth = 1;
        if(null == endYear) {
            Calendar date = Calendar.getInstance();
            endYear = Integer.valueOf(date.get(Calendar.YEAR));
        }
        if(null == endMonth){
            endMonth = 12;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setLenient(false);
        Timestamp begin = null;
        Timestamp end = null;
        try{
            begin = new Timestamp(format.parse(beginYear + "-" + beginMonth +"-1 00:00:00").getTime());
            end = new Timestamp(format.parse(endYear + "-" + endMonth+"-30 00:00:00").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Timestamp> timestamps = new ArrayList<>();
        timestamps.add(begin);
        timestamps.add(end);
        return timestamps;

    }
}
