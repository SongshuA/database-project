package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.DateCreate;
import util.MysqlConnection;

public class DeviceTroubleshootingManager implements EntityManager<DeviceTroubleshooting>{
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private DeviceTroubleshootingManager(){
    }

    @Override
    public boolean insert(DeviceTroubleshooting entity) {
        return false;
    }

    @Override
    public boolean update(DeviceTroubleshooting entity) {
        return false;
    }

    @Override
    public boolean delete(DeviceTroubleshooting entity) {
        return false;
    }

    private static class SingletonFactory{
        private static DeviceTroubleshootingManager instance = new DeviceTroubleshootingManager();
    }

    public static DeviceTroubleshootingManager getInstance(){
        return DeviceTroubleshootingManager.SingletonFactory.instance;
    }

    public List<DeviceTroubleshooting> get(Integer beginYear, Integer beginMonth, Integer endYear, Integer endMonth){
        List<Timestamp> timestamps = DateCreate.create(beginYear,beginMonth,endYear,endMonth);
        String selectRepairFeeSql = "select device_ID, count(brokenCount) as brokenCounts, sum(amounts) as amount_fee\n" +
                "FROM\n" +
                "(SELECT device.device_ID, count(*) as brokenCount, sum(amount) as amounts \n" +
                "FROM troubleshooting join repair_fee on troubleshooting.repair_fee_ID=repair_fee.repair_fee_ID join device on troubleshooting.device_ID = device.device_ID  \n" +
                "WHERE troubleshooting.time between ? and ?\n" +
                "group by device.device_ID\n" +
                "UNION(\n" +
                "SELECT device.device_ID, count(*) as brokenCount, sum(amount) as amounts\n" +
                "From repair_fee join `repair` on repair_fee.repair_fee_ID=`repair`.repair_fee_ID join device on `repair`.device_ID=device.device_ID\n" +
                "WHERE `repair`.time between ? and ?\n" +
                "GROUP BY device.device_ID\n" +
                ")) as n\n" +
                "GROUP BY device_ID";
        Object[] params = new Object[4];
        params[0] = timestamps.get(0);
        params[1] = timestamps.get(1);
        params[2] = timestamps.get(0);
        params[3] = timestamps.get(1);
        Object o = MysqlConnection.select(selectRepairFeeSql, rs -> {
           List<DeviceTroubleshooting> deviceTroubleshootings = new ArrayList<>();
           while (rs.next()){
               deviceTroubleshootings.add(new DeviceTroubleshooting(rs.getInt("device_ID"),rs.getInt("brokenCounts"),null,rs.getDouble("amount_fee")));
           }
           return deviceTroubleshootings;
        }, params);
        List<DeviceTroubleshooting> deviceTroubleshootings = (List<DeviceTroubleshooting>)o;
        int length = deviceTroubleshootings.size();
        Object[] paramsRepair = new Object[2];
        paramsRepair[0] = timestamps.get(0);
        paramsRepair[1] = timestamps.get(1);
        String selectRepairSql = "SELECT device.device_ID, count(*) as repairCount\n" +
                "From repair_fee join `repair` on repair_fee.repair_fee_ID=`repair`.repair_fee_ID join device on `repair`.device_ID=device.device_ID\n" +
                "WHERE `repair`.time between ? and ?\n" +
                "GROUP BY device.device_ID";
        Object b = MysqlConnection.select(selectRepairSql, rs -> {
            List<DeviceTroubleshooting> deviceTroubleshootings1 = new ArrayList<>();
            while (rs.next()){
                deviceTroubleshootings1.add(new DeviceTroubleshooting(rs.getInt("device_ID"), null, rs.getInt("repairCount"),0));
            }
            return deviceTroubleshootings1;
        },paramsRepair);
        List<DeviceTroubleshooting> deviceTroubleshootings1 =  (List<DeviceTroubleshooting>)b;
        int length1 = deviceTroubleshootings1.size();
        for(int i = 0;i<length;i++){
            DeviceTroubleshooting deviceTroubleshooting = deviceTroubleshootings.get(i);
            for(int j = 0;j<length1;j++){
                DeviceTroubleshooting deviceTroubleshooting1 = deviceTroubleshootings1.get(j);
                if(deviceTroubleshooting.getDeviceId() == deviceTroubleshooting1.getDeviceId()){
                    deviceTroubleshooting.setRepairCount(deviceTroubleshooting1.getRepairCount());
                }
            }
        }
        return deviceTroubleshootings;
    }

    public List<DeviceTroubleshooting> get(){
        String selectRepairFeeSql = "select device_ID, count(brokencount) as brokencounts, sum(amounts) as amount_fee\n" +
                "FROM\n" +
                "(SELECT device.device_ID, count(*) as brokencount, sum(amount) as amounts \n" +
                "FROM troubleshooting join repair_fee on troubleshooting.repair_fee_ID=repair_fee.repair_fee_ID join device on troubleshooting.device_ID = device.device_ID\n" +
                "group by device.device_ID\n" +
                "UNION(\n" +
                "SELECT device.device_ID, count(*) as brokencount, sum(amount) as amounts\n" +
                "From repair_fee join `repair` on repair_fee.repair_fee_ID=`repair`.repair_fee_ID join device on `repair`.device_ID=device.device_ID\n" +
                "GROUP BY device.device_ID\n" +
                ")) as n\n" +
                "GROUP BY device_ID";
        Object o = MysqlConnection.select(selectRepairFeeSql, rs -> {
            List<DeviceTroubleshooting> deviceTroubleshootings = new ArrayList<>();
            while (rs.next()){
                deviceTroubleshootings.add(new DeviceTroubleshooting(rs.getInt("device_ID"),rs.getInt("brokencounts"),null,rs.getDouble("amount_fee")));
            }
            return deviceTroubleshootings;
        });
        List<DeviceTroubleshooting> deviceTroubleshootings = (List<DeviceTroubleshooting>)o;
        int length = deviceTroubleshootings.size();
        String selectRepairSql = "SELECT device.device_ID, count(*) as repairCount, sum(amount) as amounts\n" +
                "From repair_fee join `repair` on repair_fee.repair_fee_ID=`repair`.repair_fee_ID join device on `repair`.device_ID=device.device_ID\n" +
                "GROUP BY device.device_ID";
        Object b = MysqlConnection.select(selectRepairSql, rs -> {
            List<DeviceTroubleshooting> deviceTroubleshootings1 = new ArrayList<>();
            while (rs.next()){
                deviceTroubleshootings1.add(new DeviceTroubleshooting(rs.getInt("device_ID"), null, rs.getInt("repairCount"),0));
            }
            return deviceTroubleshootings1;
        });
        List<DeviceTroubleshooting> deviceTroubleshootings1 =  (List<DeviceTroubleshooting>)b;
        int length1 = deviceTroubleshootings1.size();
        for(int i = 0;i<length;i++){
            DeviceTroubleshooting deviceTroubleshooting = deviceTroubleshootings.get(i);
            for(int j = 0;j<length1;j++){
                DeviceTroubleshooting deviceTroubleshooting1 = deviceTroubleshootings1.get(j);
                if(deviceTroubleshooting.getDeviceId() == deviceTroubleshooting1.getDeviceId()){
                    deviceTroubleshooting.setRepairCount(deviceTroubleshooting1.getRepairCount());
                }
            }
        }
        return deviceTroubleshootings;    }
}
