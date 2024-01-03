package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.Schedule;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.ScheduleDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.ScheduleDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOimpl implements ScheduleDAO {
    public  boolean save(Schedule dto) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "INSERT INTO schedule VALUES(?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, dto.getScheduleId());
//        pstm.setObject(2, dto.getType());
//        pstm.setObject(3, dto.getDate());
//        pstm.setObject(4, dto.getPlane());
//        boolean isSaved = pstm.executeUpdate() > 0;
        return SQLUtil.execute("INSERT INTO schedule VALUES(?,?,?,?)",dto.getScheduleId(),dto.getType(),dto.getDate(),dto.getPlane());
    }

    public  boolean delete(String scheduleId) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "DELETE FROM schedule WHERE scheduleId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, scheduleId);
//        boolean isDeleted = pstm.executeUpdate() > 0;
        return SQLUtil.execute("DELETE FROM schedule WHERE scheduleId=?",scheduleId);
    }



    public  boolean update(Schedule dto) throws Exception{
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "UPDATE schedule SET type=?,date=?,plane=? WHERE scheduleId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, dto.getType());
//        pstm.setObject(2, dto.getDate());
//        pstm.setObject(3, dto.getPlane());
//        pstm.setObject(4, dto.getScheduleId());
       return SQLUtil.execute("UPDATE schedule SET type=?,date=?,plane=? WHERE scheduleId=?",dto.getType(),dto.getDate(),dto.getPlane(),dto.getScheduleId());
    }

    public  Schedule search(String scheduleId) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "SELECT * FROM schedule WHERE scheduleId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, scheduleId);
      //  Schedule dto = new Schedule();
        ResultSet rst = SQLUtil.execute("SELECT * FROM schedule WHERE scheduleId=?",scheduleId);
        if (rst.next()) {
//            dto.setScheduleId(rst.getString(1));
//            dto.setType(rst.getString(2));
//            dto.setDate(rst.getString(3));
//            dto.setPlane(rst.getString(4));
        }
        return new Schedule(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
    }

    public  List<Schedule> getAll() throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "SELECT * FROM schedule";
//        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = SQLUtil.execute("SELECT * FROM schedule");
        List<Schedule> allSchedules = new ArrayList<>();
        while (rst.next()) {
//            ScheduleDto dto = new ScheduleDto();
//            dto.setScheduleId(rst.getString(1));
//            dto.setType(rst.getString(2));
//            dto.setDate(rst.getString(3));
//            dto.setPlane(rst.getString(4));
//            allSchedules.add(dto);
            allSchedules.add(new Schedule(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return allSchedules;
    }
}
