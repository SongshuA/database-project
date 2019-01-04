package util;
import entity.Entity;

import java.sql.*;
import java.sql.DriverManager;
import java.util.List;

public class MysqlConnection {
    private static String url = "jdbc:mysql://localhost:3306/dbpj?characterEncoding=utf-8";
    private static String user = "root";
    private static String password = "971219";

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //设置 PreparedStatement 参数
    private static void setParams(PreparedStatement preStmt, Object... params)
            throws SQLException {
        if (params == null || params.length == 0)
            return;
        for (int i = 1; i <= params.length; i++) {
            Object param = params[i - 1];
            if (param == null) {
                preStmt.setNull(i, Types.NULL);
            } else if (param instanceof Integer) {
                preStmt.setInt(i, (Integer) param);
            } else if (param instanceof String) {
                preStmt.setString(i, (String) param);
            } else if (param instanceof Double) {
                preStmt.setDouble(i, (Double) param);
            } else if (param instanceof Long) {
                preStmt.setDouble(i, (Long) param);
            } else if (param instanceof Timestamp) {
                preStmt.setTimestamp(i, (Timestamp) param);
            } else if (param instanceof Boolean) {
                preStmt.setBoolean(i, (Boolean) param);
            } else if (param instanceof Date) {
                preStmt.setDate(i, (Date) param);
            } else if (param instanceof Float){
                preStmt.setFloat(i, (Float) param);
            }
        }
    }


    //执行 SQL，返回影响的行数 异常处理
    public static int executeUpdate(String sql){
        return executeUpdate(sql, new Object[] {});
    }

    //带参数执行SQL，返回影响的行数 异常处理
    public static int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = getConnection();
            assert conn != null;
            preStmt = conn.prepareStatement(sql);
            setParams(preStmt, params);
            int result = preStmt.executeUpdate();
            preStmt.close();
            conn.close();
            return result; //执行SQL操作
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Object select(String sql, ResultSetHandler handler, Object... params){
                Connection conn = null;
                PreparedStatement preStmt = null;
                ResultSet rs = null;
                try{
                    conn = getConnection();
                    preStmt = conn.prepareStatement(sql);
                    setParams(preStmt, params);
                    rs = preStmt.executeQuery();
                    Object entityList = handler.handle(rs);
                    preStmt.close();
                    conn.close();
                    return entityList;
                } catch (SQLException e) {
                    e.printStackTrace();
        }
        return null;
    }


}
