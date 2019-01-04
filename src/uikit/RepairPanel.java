package uikit;


import entity.Repair;
import entity.RepairManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class RepairPanel extends Panel {
    public RepairPanel(){
        super(Repair.class, RepairManager.getInstance(), new String[]{"beginYear","beginMonth", "endYear", "endMonth"}, false);
        this.queryPane.setOnQuery(queries -> {
            RepairManager manager = (RepairManager)this.manager;

            Integer beginYear = Utils.parseInt(queries[0]);
            Integer beginMonth = Utils.parseInt(queries[1]);

            Integer endYear = Utils.parseInt(queries[2]);
            Integer endMonth = Utils.parseInt(queries[3]);

            List<Repair> repairFees = manager.get(beginYear, beginMonth, endYear, endMonth);
            this.table.refresh(new ArrayList<>(repairFees));
        });


    }
}
