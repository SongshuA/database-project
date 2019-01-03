import entity.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Complaint complaint = new Complaint(1, "王锴", timestamp, "666",4,null,null,null);
        ComplaintManager complaintManager = new ComplaintManager();
        complaintManager.insert(complaint);
//        Unit unit = new Unit(1,2,"王锴");
//        UnitManager unitManager = new UnitManager();
//        unitManager.insert(unit);

    }
}
