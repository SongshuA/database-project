package uikit;

import entity.DeviceTroubleshooting;
import entity.DeviceTroubleshootingManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class DeviceTroubleshootingPanel extends Panel {
    public DeviceTroubleshootingPanel(){
        super(DeviceTroubleshooting.class, DeviceTroubleshootingManager.getInstance(), new String[]{"beginYear","beginMonth", "endYear", "endMonth"}, false);

        this.queryPane.setOnQuery(queries -> {
            DeviceTroubleshootingManager manager = (DeviceTroubleshootingManager)this.manager;

            Integer beginYear = Utils.parseInt(queries[0]);
            Integer beginMonth = Utils.parseInt(queries[1]);

            Integer endYear = Utils.parseInt(queries[2]);
            Integer endMonth = Utils.parseInt(queries[3]);

            List<DeviceTroubleshooting> balanceList = manager.get(beginYear, beginMonth, endYear, endMonth);
            this.table.refresh(new ArrayList<>(balanceList));
        });
    }
}
