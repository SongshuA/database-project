package uikit;

import entity.RepairFee;
import entity.RepairFeeManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class RepairFeePanel extends Panel {
    public RepairFeePanel(){
        super(RepairFee.class, RepairFeeManager.getInstance(), new String[]{"beginYear","beginMonth", "endYear", "endMonth"}, true);
        this.queryPane.setOnQuery(queries -> {
            RepairFeeManager manager = (RepairFeeManager)this.manager;

            Integer beginYear = Utils.parseInt(queries[0]);
            Integer beginMonth = Utils.parseInt(queries[1]);

            Integer endYear = Utils.parseInt(queries[2]);
            Integer endMonth = Utils.parseInt(queries[3]);

            List<RepairFee> repairFees = manager.get(beginYear, beginMonth, endYear, endMonth);
            this.table.refresh(new ArrayList<>(repairFees));
        });


    }
}
