package uikit;

import entity.ParkingSlot;
import entity.ParkingSlotManager;
import uikit.common.Panel;

public class ParkingSlotPanel extends Panel {
    public ParkingSlotPanel(){
        super(ParkingSlot.class, ParkingSlotManager.getInstance(), null , true);
    }
}
