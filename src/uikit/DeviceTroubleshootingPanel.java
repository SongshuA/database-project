package uikit;

import entity.DeviceTroubleshooting;
import entity.DeviceTroubleshootingManager;
import uikit.common.Panel;

public class DeviceTroubleshootingPanel extends Panel {
    public DeviceTroubleshootingPanel(){
        super(DeviceTroubleshooting.class, DeviceTroubleshootingManager.getInstance(), null, false);
    }
}
