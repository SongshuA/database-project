package uikit;

import entity.FreeHouse;
import entity.FreeHouseManager;
import uikit.common.Panel;
import uikit.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class FreeHousePanel extends Panel {
    public FreeHousePanel(){
        super(FreeHouse.class, FreeHouseManager.getInstance(), new String[]{"community_name"}, true);
        this.queryPane.setOnQuery(queries -> {
            FreeHouseManager manager = (FreeHouseManager)this.manager;
            String communityName = Utils.parseString(queries[0]);
            List<FreeHouse> freeHouses = manager.get(communityName);
            this.table.refresh(new ArrayList<>(freeHouses));
        });
    }
}
