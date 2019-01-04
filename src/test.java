import entity.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class test {
    public static void main(String[] args) {
        DeviceTroubleshootingManager deviceTroubleshootingManager = new DeviceTroubleshootingManager();
        List<DeviceTroubleshooting> deviceTroubleshootings = deviceTroubleshootingManager.get();
        System.out.println(deviceTroubleshootings.size());
    }
}
