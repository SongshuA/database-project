package uikit;

import uikit.common.Container;

public class MainContainer extends Container {
    public MainContainer(){
        super();

        this.addPanel(new CommunityPanel());
        this.addPanel(new ParkingSlotPanel());
        this.addPanel(new FreeHousePanel());
        this.addPanel(new ResidentPanel());
        this.addPanel(new BalancePanel());
        this.addPanel(new ComplaintPanel());
        this.addPanel(new MonthBillPanel());
        this.addPanel(new TroubleshootingPanel());
        this.addPanel(new RepairFeePanel());
        this.addPanel(new RepairPanel());
        this.addPanel(new DeviceTroubleshootingPanel());
        this.addPanel(new UserRepairPanel());
    }
}
