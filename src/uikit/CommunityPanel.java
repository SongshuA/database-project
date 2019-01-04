package uikit;

import entity.Community;
import entity.CommunityManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;

public class CommunityPanel extends Panel {
    public CommunityPanel(){
        super(Community.class, CommunityManager.getInstance(), null, false);
    }
}