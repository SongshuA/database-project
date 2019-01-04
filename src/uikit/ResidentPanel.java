package uikit;

import entity.Resident;
import entity.ResidentManager;
import uikit.common.Panel;

public class ResidentPanel extends Panel {
    public ResidentPanel(){
        super(Resident.class, ResidentManager.getInstance(), null, true);
    }
}
