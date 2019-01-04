package uikit;

import entity.Community;
import entity.CommunityManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;

public class CommunityPanel extends Panel {
    public CommunityPanel(){
        super(Community.class, CommunityManager.getInstance(), new String[]{"lessProperty"}, false);

        this.queryPane.setOnQuery(queries -> {
            CommunityManager manager = (CommunityManager)this.manager;

            Float lessProperty = Utils.parseFloat(queries[0]);

            this.table.refresh(new ArrayList<>(manager.get(lessProperty)));
        });
    }
}