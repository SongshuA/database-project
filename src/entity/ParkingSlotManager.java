package entity;

import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class ParkingSlotManager implements EntityManager<ParkingSlot>{
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private ParkingSlotManager(){
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
                parkingSlots.add(new ParkingSlot(rs.getInt("parking_slot_ID"),rs.getString("position"),rs.getInt("occupied"),rs.getString("community_name"),rs.getString("type"),(double)0));
            }
            return parkingSlots;
        });
        List<ParkingSlot> parkingSlots = (List<ParkingSlot>) o;
        int length = parkingSlots.size();
        String amountSql = "SELECT parking_slot_ID,sum(amount) as amount FROM parking_slot natural join park_fee group by parking_slot_ID";
        Object b = MysqlConnection.select(amountSql, rs -> {
            List<ParkingSlot> parkingSlots1 = new ArrayList<>();
            while (rs.next()){
                parkingSlots1.add(new ParkingSlot(rs.getInt("parking_slot_ID"),null,null,null,null,rs.getDouble("amount")));
            }
            return parkingSlots1;
        });
        List<ParkingSlot> parkingSlots1 = (List<ParkingSlot>)b;
        int length1 = parkingSlots1.size();
        for(int i = 0;i<length;i++){
            ParkingSlot parkingSlot = parkingSlots.get(i);
            for(int j = 0;j<length1;j++){
                ParkingSlot parkingSlot1 = parkingSlots1.get(j);
                if(parkingSlot.getId() == parkingSlot1.getId()){
                    parkingSlot.setAmount(parkingSlot1.getAmount());
                }
            }
        }

        return parkingSlots;
    }

    @Override
    public boolean insert(ParkingSlot entity) {
        return false;
    }

    @Override
    public boolean update(ParkingSlot entity) {
        return false;
    }

    @Override
    public boolean delete(ParkingSlot entity) {
        return false;
    }
}
