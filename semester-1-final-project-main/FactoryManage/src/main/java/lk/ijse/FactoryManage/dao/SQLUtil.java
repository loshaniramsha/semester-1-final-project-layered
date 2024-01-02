package lk.ijse.FactoryManage.dao;

import lk.ijse.FactoryManage.db.DbConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(String sql, Object...ob) throws Exception {
        Connection connection= DbConection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);
        for (int i = 0; i < ob.length; i++) {
            pstm.setObject(i+1,ob[i]);
        }
        if (sql.startsWith("SELECT")||sql.startsWith("select")){
            return (T) pstm.executeQuery();
        }else {
            return (T) (Boolean)(pstm.executeUpdate()>0);
        }
    }
}
