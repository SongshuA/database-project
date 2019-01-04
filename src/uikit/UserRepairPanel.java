package uikit;

import entity.UserRepair;
import entity.UserRepairManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserRepairPanel extends Panel {
    public UserRepairPanel(){
        super(UserRepair.class, UserRepairManager.getInstance(), new String[]{"beginYear","beginMonth", "endYear", "endMonth"}, false);
        this.queryPane.setOnQuery(queries -> {
            UserRepairManager manager = (UserRepairManager)this.manager;

            Integer beginYear = Utils.parseInt(queries[0]);
            Integer beginMonth = Utils.parseInt(queries[1]);

            Integer endYear = Utils.parseInt(queries[2]);
            Integer endMonth = Utils.parseInt(queries[3]);

            List<UserRepair> balanceList = manager.get(beginYear, beginMonth, endYear, endMonth);
            this.table.refresh(new ArrayList<>(balanceList));
        });
    }
}
