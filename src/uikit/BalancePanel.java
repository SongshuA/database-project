package uikit;

import entity.Balance;
import entity.BalanceManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;


public class BalancePanel extends Panel {
    public BalancePanel() {
        super(Balance.class, BalanceManager.getInstance(), new String[]{"beginYear","beginMonth", "endYear", "endMonth"}, false);
        this.queryPane.setOnQuery(queries -> {
            BalanceManager manager = (BalanceManager)this.manager;

            Integer beginYear = Utils.parseInt(queries[0]);
            Integer beginMonth = Utils.parseInt(queries[1]);

            Integer endYear = Utils.parseInt(queries[2]);
            Integer endMonth = Utils.parseInt(queries[3]);

            List<Balance> balanceList = manager.get(beginYear, beginMonth, endYear, endMonth);
            this.table.refresh(new ArrayList<>(balanceList));
        });
    }
}
