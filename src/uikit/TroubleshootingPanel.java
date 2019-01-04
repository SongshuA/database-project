package uikit;

import entity.Troubleshooting;
import entity.TroubleshootingManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class TroubleshootingPanel extends Panel {
    public TroubleshootingPanel(){
        super(Troubleshooting.class, TroubleshootingManager.getInstance(), new String[]{"beginYear","beginMonth", "endYear", "endMonth"}, true);
        this.queryPane.setOnQuery(queries -> {
            TroubleshootingManager manager = (TroubleshootingManager)this.manager;

            Integer beginYear = Utils.parseInt(queries[0]);
            Integer beginMonth = Utils.parseInt(queries[1]);

            Integer endYear = Utils.parseInt(queries[2]);
            Integer endMonth = Utils.parseInt(queries[3]);

            List<Troubleshooting> troubleshootings = manager.get(beginYear, beginMonth, endYear, endMonth);
            this.table.refresh(new ArrayList<>(troubleshootings));
        });
    }
}
