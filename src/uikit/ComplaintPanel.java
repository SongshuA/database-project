package uikit;

import entity.Complaint;
import entity.ComplaintManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class ComplaintPanel extends Panel {
    public ComplaintPanel(){
        super(Complaint.class, ComplaintManager.getInstance(), new String[]{
                "beginYear", "beginMonth", "endYear", "endMonth",
                "community_name", "unit_ID", "house_ID", "household_ID", "type"
        }, true);

        this.queryPane.setOnQuery(queries -> {
            ComplaintManager manager = (ComplaintManager)this.manager;

            Integer beginYear = Utils.parseInt(queries[0]);
            Integer beginMonth = Utils.parseInt(queries[1]);
            Integer endYear = Utils.parseInt(queries[2]);
            Integer endMonth = Utils.parseInt(queries[3]);
            String communityName = Utils.parseString(queries[4]);
            Integer unitId = Utils.parseInt(queries[5]);
            Integer houseId = Utils.parseInt(queries[6]);
            Integer householdId = Utils.parseInt(queries[7]);
            String type = Utils.parseString(queries[8]);

            List<Complaint> complaintList = manager.get(beginYear, beginMonth, endYear, endMonth, communityName, unitId, houseId, householdId, type);
            this.table.refresh(new ArrayList<>(complaintList));
        });
    }
}
