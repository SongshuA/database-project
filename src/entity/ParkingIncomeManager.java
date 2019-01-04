package entity;

import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class ParkingIncomeManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public ParkingIncomeManager(){
    }

    private static class SingletonFactory{
        private static ParkingIncomeManager instance = new ParkingIncomeManager();
    }

    public static ParkingIncomeManager getInstance(){
        return ParkingIncomeManager.SingletonFactory.instance;
    }


    public List<ParkingIncome> get(){
        String selectSql = "SELECT * FROM park_fee";
        Object o = MysqlConnection.select(selectSql, rs->{
            List<ParkingIncome> result = new ArrayList<>();
            while (rs.next()){
                Integer slotId = rs.getInt("parking_slot_ID");
                String queryPosition = "SELECT * FROM parking_slot WHERE park_fee_ID='" + slotId + "'";
                Object position = MysqlConnection.select(queryPosition, r->{
                    List<ParkingSlot> result1 = new ArrayList<>();
                    while (r.next()){
                        ParkingSlot parkingSlot = new ParkingSlot(r.getInt("park_fee_ID"),r.getString("position"),null,null,null,null);
                        result1.add(parkingSlot);
                    }
                    return result1;
                });
                List<ParkingSlot> parkingSlots = (List<ParkingSlot>)position;
                result.add(new ParkingIncome(rs.getInt("park_fee_ID"),rs.getInt("parking_slot_ID"),rs.getInt("household_ID"),rs.getFloat("amount"),rs.getTimestamp("time"),rs.getInt("paied"),rs.getString("description"),parkingSlots.get(0).getPosition()));
            }
            return result;
        });
        return (List<ParkingIncome>)o;
    }
}
