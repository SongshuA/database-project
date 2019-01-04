import entity.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class test {
    public static void main(String[] args) {
        MonthBillManager monthBillManager = new MonthBillManager();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setLenient(false);
        try{
            Timestamp begin = new Timestamp(format.parse("2019-1-1 12:12:12").getTime());
            Timestamp end = new Timestamp(format.parse("2019-1-5 10:10:00").getTime());
            List<MonthBill> monthBills = monthBillManager.get(4,begin, end);
            System.out.println(monthBills.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
