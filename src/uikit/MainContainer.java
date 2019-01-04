package uikit;

import uikit.common.Container;

public class MainContainer extends Container {
    public MainContainer(){
        super();

        this.addPanel(new CommunityPanel());
        this.addPanel(new BalancePanel());
        this.addPanel(new ComplaintPanel());
        this.addPanel(new DeviceTroubleshootingPanel());
        this.addPanel(new MonthBillPanel());
        this.addPanel(new ParkingSlotPanel());
        this.addPanel(new UserRepairPanel());
        this.addPanel(new FreeHousePanel());
    }
}
