package util;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler {
    Object handle(ResultSet rs) throws SQLException;
}
