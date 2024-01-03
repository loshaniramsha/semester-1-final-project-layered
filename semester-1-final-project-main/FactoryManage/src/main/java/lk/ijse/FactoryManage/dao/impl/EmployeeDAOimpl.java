package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.Employee;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.EmployeeDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.EmployeeDto;
import lk.ijse.FactoryManage.dto.ExportableDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO  {

    public  boolean save(Employee dto) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, dto.getEmployeeId());
//        pstm.setObject(2, dto.getName());
//        pstm.setObject(3, dto.getType());
//        pstm.setObject(4, dto.getEmail());
//        pstm.setObject(5, dto.getPhone());
//       pstm.setObject(6,dto.getUserId());
//       pstm.setObject(7,dto.getScheduleId());
        boolean isSaved = SQLUtil.execute("INSERT INTO employee VALUES(?,?,?,?,?,?,?)",dto.getEmployeeId(),dto.getName(),dto.getType(),dto.getEmail(),dto.getPhone(),dto.getUserId(),dto.getScheduleId());
        return isSaved;
    }



    public  boolean delete(String employeeId) throws Exception  {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "DELETE FROM employee WHERE employeeId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, employeeId);
        boolean isDeleted = SQLUtil.execute("DELETE FROM employee WHERE employeeId=?",employeeId);
        return isDeleted;
    }



    public  boolean update(Employee dto) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "UPDATE employee SET type=?,name=?,email=?,phone=?,userId=?,scheduleId=? WHERE employeeId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, dto.getType());
//        pstm.setObject(2, dto.getName());
//        pstm.setObject(3, dto.getEmail());
//        pstm.setObject(4, dto.getPhone());
//        pstm.setObject(5, dto.getUserId());
//        pstm.setObject(6, dto.getScheduleId());
//        pstm.setObject(7, dto.getEmployeeId());
        boolean isUpdated = SQLUtil.execute("UPDATE employee SET type=?,name=?,email=?,phone=?,userId=?,scheduleId=? WHERE employeeId=?",dto.getType(),dto.getName(),dto.getEmail(),dto.getPhone(),dto.getUserId(),dto.getScheduleId(),dto.getEmployeeId());
        return isUpdated;
    }

    public Employee search(String employeeId)  throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "SELECT * FROM employee WHERE employeeId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, employeeId);
//       // EmployeeDto employeeDto = null;
//        Employee employeeDto = null;
        ResultSet rst = SQLUtil.execute("SELECT * FROM employee WHERE employeeId=?",employeeId);
        while (rst.next()) {
//            String type = rst.getString(2);
//            String name = rst.getString(3);
//            String email = rst.getString(4);
//            String phone = rst.getString(5);
//            String userId = rst.getString(6);
//            String scheduleId = rst.getString(7);
//            employeeDto = new Employee(employeeId, type, name, email, phone, userId, scheduleId);
        }
        return new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7));
    }



    public List<Employee> getAll() throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "SELECT * FROM employee";
//        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = SQLUtil.execute("SELECT * FROM employee");
        List<Employee> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7)));
//            String employeeId = rst.getString(1);
//            String type = rst.getString(2);
//            String name = rst.getString(3);
//            String email = rst.getString(4);
//            String phone = rst.getString(5);
//            String userId = rst.getString(6);
//            String scheduleId = rst.getString(7);
//            list.add(new Employee(employeeId, type, name, email, phone, userId, scheduleId));
        }
        return list;
    }
}

