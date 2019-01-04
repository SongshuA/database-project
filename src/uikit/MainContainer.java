package uikit;

import uikit.common.Container;

public class MainContainer extends Container {
    public MainContainer(){
        super();

        this.addPanel(new CommunityPanel());
    }
}
