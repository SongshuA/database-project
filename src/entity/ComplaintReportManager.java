package entity;

import util.MysqlConnection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ComplaintReportManager implements EntityManager<ComplaintReport>{
    /* 单例模式，后续的实体管理器请按照这个格式设计 */
    private ComplaintReportManager() {}

    @Override
    public List<ComplaintReport> get() {
        return new ArrayList<>();
    }

    @Override
    public boolean insert(ComplaintReport entity) {
        return false;
    }

    @Override
    public boolean update(ComplaintReport entity) {
        return false;
    }

    @Override
    public boolean delete(ComplaintReport entity) {
        return false;
    }

    private static class SingletonFactory {
        private static ComplaintReportManager instance = new ComplaintReportManager();
    }

    public static ComplaintReportManager getInstance() {
        return ComplaintReportManager.SingletonFactory.instance;
    }

    public List<ComplaintReport> get(Timestamp begin, Timestamp end, boolean community_name, boolean unit_ID, boolean house_ID, boolean household_ID, boolean type) {
        Object[] params = new Object[2];
        params[0] = begin;
        params[1] = end;
        if (community_name) {
            String selectSql = "SELECT community_name count(*) as count FROM complaint natural join household natural join house natural join community WHERE time between ? and ? group by community_name";
            Object o = MysqlConnection.select(selectSql, rs -> {
                List<ComplaintReport> complaintReports = new ArrayList<>();
                while (rs.next()) {
                    complaintReports.add(new ComplaintReport(rs.getString("community_name"), null, null, null, null, rs.getInt("count")));
                }
                return complaintReports;
            }, params);
            return (List<ComplaintReport>)o;
        }else if(unit_ID){
            String selectSql = "SELECT unit_ID count(*) as count FROM complaint natural join household natural join house natural join community WHERE time between ? and ? group by unit_ID";
            Object o = MysqlConnection.select(selectSql, rs -> {
                List<ComplaintReport> complaintReports = new ArrayList<>();
                while (rs.next()) {
                    complaintReports.add(new ComplaintReport(null, null, rs.getInt("unit_ID"), null, null, rs.getInt("count")));
                }
                return complaintReports;
            }, params);
            return (List<ComplaintReport>)o;
        }else if(house_ID){
            String selectSql = "SELECT house_ID count(*) as count FROM complaint natural join household natural join house natural join community WHERE time between ? and ? group by house_ID";
            Object o = MysqlConnection.select(selectSql, rs -> {
                List<ComplaintReport> complaintReports = new ArrayList<>();
                while (rs.next()) {
                    complaintReports.add(new ComplaintReport(null, rs.getInt("house_ID"), null, null, null, rs.getInt("count")));
                }
                return complaintReports;
            }, params);
            return (List<ComplaintReport>)o;
        }else if(household_ID){
            String selectSql = "SELECT household_ID count(*) as count FROM complaint natural join household natural join house natural join community WHERE time between ? and ? group by household_ID";
            Object o = MysqlConnection.select(selectSql, rs -> {
                List<ComplaintReport> complaintReports = new ArrayList<>();
                while (rs.next()) {
                    complaintReports.add(new ComplaintReport(null, null, null, rs.getInt("household_ID"), null, rs.getInt("count")));
                }
                return complaintReports;
            }, params);
            return (List<ComplaintReport>)o;
        }else {
            String selectSql = "SELECT type count(*) as count FROM complaint natural join household natural join house natural join community WHERE time between ? and ? group by type";
            Object o = MysqlConnection.select(selectSql, rs -> {
                List<ComplaintReport> complaintReports = new ArrayList<>();
                while (rs.next()) {
                    complaintReports.add(new ComplaintReport(null, null, null, null, rs.getString("type"), rs.getInt("count")));
                }
                return complaintReports;
            }, params);
            return (List<ComplaintReport>)o;
        }
    }
}

