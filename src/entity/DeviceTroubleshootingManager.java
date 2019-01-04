package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.MysqlConnection;

public class DeviceTroubleshootingManager {
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    public DeviceTroubleshootingManager(){
    }

    private static class SingletonFactory{
        private static DeviceTroubleshootingManager instance = new DeviceTroubleshootingManager();
    }

    public static DeviceTroubleshootingManager getInstance(){
        return DeviceTroubleshootingManager.SingletonFactory.instance;
    }

    public List<DeviceTroubleshooting> get(Timestamp begin, Timestamp end){
        String selectRepairFeeSql = "SELECT device_ID, count(*) as count, count(amount) as amounts FROM repair_fee natural join troubleshooting natural join device WHERE time between ? and ? group by device_ID";
        Object[] params = new Object[2];
        params[0] = begin;
        params[1] = end;
        Object o = MysqlConnection.select(selectRepairFeeSql, rs -> {
           List<DeviceTroubleshooting> deviceTroubleshootings = new ArrayList<>();
           while (rs.next()){
               deviceTroubleshootings.add(new DeviceTroubleshooting(rs.getInt("device_ID"),rs.getInt("count"),null,rs.getInt("amounts")));
           }
           return deviceTroubleshootings;
        }, params);
        List<DeviceTroubleshooting> deviceTroubleshootings = new ArrayList<>();
        deviceTroubleshootings = (List<DeviceTroubleshooting>)o;
        int length = deviceTroubleshootings.size();
        String selectRepairSql = "SELECT device_ID, count(*) as count FROM repair natural join device WHERE time between ? and ? group by device_ID";
        Object b = MysqlConnection.select(selectRepairSql, rs -> {
            List<DeviceTroubleshooting> deviceTroubleshootings1 = new ArrayList<>();
            while (rs.next()){
                deviceTroubleshootings1.add(new DeviceTroubleshooting(rs.getInt("device_ID"), null, rs.getInt("count"),0));
            }
            return deviceTroubleshootings1;
        },params);
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
}
