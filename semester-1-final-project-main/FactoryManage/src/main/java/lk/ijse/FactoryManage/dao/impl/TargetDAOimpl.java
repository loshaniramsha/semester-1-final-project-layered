package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.Target;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.TargetDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.TargetDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TargetDAOimpl  implements TargetDAO {
    public  boolean save(Target dto) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "INSERT INTO target VALUES(?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, dto.getTargetId());
//        pstm.setObject(2, dto.getTargetAmount());
//        pstm.setObject(3, dto.getReceiveDate());
//        pstm.setObject(4, dto.getSendDate());
//        boolean isSaved = pstm.executeUpdate() > 0;
        return SQLUtil.execute("INSERT INTO target VALUES(?,?,?,?)",dto.getTargetId(),dto.getTargetAmount(),dto.getReceiveDate(),dto.getSendDate());
    }

    public  boolean delete(String targetId) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "DELETE FROM target WHERE targetId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, targetId);
//        boolean isDeleted = pstm.executeUpdate() > 0;
        return SQLUtil.execute("DELETE FROM target WHERE targetId=?", targetId);
    }

    public  boolean update(Target dto) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "UPDATE target SET targetAmount=?,receiveDate=?,sendDate=? WHERE targetId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, dto.getTargetAmount());
//        pstm.setObject(2, dto.getReceiveDate());
//        pstm.setObject(3, dto.getSendDate());
//        pstm.setObject(4, dto.getTargetId());
        return SQLUtil.execute("UPDATE target SET targetAmount=?,receiveDate=?,sendDate=? WHERE targetId=?",dto.getTargetAmount(),dto.getReceiveDate(),dto.getSendDate(),dto.getTargetId());
    }

    public  Target search(String targetId) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "SELECT * FROM target WHERE targetId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, targetId);
//        Target dto = new Target();
        ResultSet rst = SQLUtil.execute("SELECT * FROM target WHERE targetId=?",targetId);
        if (rst.next()) {
//            dto.setTargetId(rst.getString(1));
//            dto.setTargetAmount(rst.getString(2));
//            dto.setReceiveDate(rst.getString(3));
//            dto.setSendDate(rst.getString(4));
        }
        return new Target(targetId, rst.getString(2), rst.getString(3), rst.getString(4));
    }


    public List<Target> getAll() throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "SELECT * FROM target";
//        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = SQLUtil.execute("SELECT * FROM target");
        List<Target> allTargets = new ArrayList<>();
        while (rst.next()) {
            allTargets.add(new Target(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
//            TargetDto dto = new TargetDto();
//            dto.setTargetId(rst.getString(1));
//            dto.setTargetAmount(rst.getString(2));
//            dto.setReceiveDate(rst.getString(3));
//            dto.setSendDate(rst.getString(4));
//            allTargets.add(dto);
        }
        return allTargets;
    }
}
