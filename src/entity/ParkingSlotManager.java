package entity;

import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class ParkingSlotManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public ParkingSlotManager(){
    }

    private static class SingletonFactory{
        private static ParkingSlotManager instance = new ParkingSlotManager();
    }

    public static ParkingSlotManager getInstance(){
        return ParkingSlotManager.SingletonFactory.instance;
    }

    public List<ParkingSlot> get(){
        String selectSql = "SELECT * FROM parking_slot";
        Object o = MysqlConnection.select(selectSql, rs->{
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            while (rs.next()){
                parkingSlots.add(new ParkingSlot(rs.getInt("parking_slot_ID"),rs.getString("position"),rs.getInt("occupied"),rs.getString("community_name")));
            }
            return parkingSlots;
        });
        return (List<ParkingSlot>) o;
    }
}
