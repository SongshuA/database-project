package uikit;

import entity.MonthBill;
import entity.MonthBillManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class MonthBillPanel extends Panel {
    public MonthBillPanel(){
        super(MonthBill.class, MonthBillManager.getInstance(), new String[]{"householdId", "beginYear","beginMonth", "endYear", "endMonth"}, false);

        this.queryPane.setOnQuery(queries -> {
            MonthBillManager manager = (MonthBillManager)this.manager;

            Integer householdId = Utils.parseInt(queries[0]);
            Integer beginYear = Utils.parseInt(queries[1]);
            Integer beginMonth = Utils.parseInt(queries[2]);
            Integer endYear = Utils.parseInt(queries[3]);
            Integer endMonth = Utils.parseInt(queries[4]);

            List<MonthBill> balanceList = manager.get(householdId, beginYear, beginMonth, endYear, endMonth);
            this.table.refresh(new ArrayList<>(balanceList));
        });
    }
}
