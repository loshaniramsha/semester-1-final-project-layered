package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.User;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.UserDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements UserDAO {
    public  boolean save(User dto) throws Exception {
//    Connection connection= DbConection.getInstance().getConnection();
//    String sql="INSERT INTO user VALUES(?,?,?,?,?)";
//    PreparedStatement pstm=connection.prepareStatement(sql);
//    pstm.setObject(1,dto.getUserId());
//    pstm.setObject(2,dto.getPost());
//    pstm.setObject(3,dto.getName());
//    pstm.setObject(4,dto.getBranch());
//    pstm.setObject(5,dto.getPassword());
//    boolean isSaved=pstm.executeUpdate()>0;
    return SQLUtil.execute("INSERT INTO user VALUES(?,?,?,?,?)",dto.getUserId(),dto.getPost(),dto.getName(),dto.getBranch(),dto.getPassword());



    }

    public  boolean delete(String userId) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="DELETE FROM user WHERE userId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,userId);
//        boolean isDeleted=pstm.executeUpdate()>0;
        return SQLUtil.execute("DELETE FROM user WHERE userId=?",userId);

    }

    public  boolean update(User dto) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="UPDATE user SET post=?,name=?,branch=?,password=? WHERE userId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getPost());
//        pstm.setObject(2,dto.getName());
//        pstm.setObject(3,dto.getBranch());
//        pstm.setObject(4,dto.getUserId());
//        pstm.setObject(5,dto.getPassword());
        return SQLUtil.execute("UPDATE user SET post=?,name=?,branch=?,password=? WHERE userId=?",dto.getPost(),dto.getName(),dto.getBranch(),dto.getPassword(),dto.getUserId());
    }

    public  User search(String userId) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM user WHERE userId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,userId);
//        User dto=new User();
        ResultSet rst=SQLUtil.execute("SELECT * FROM user WHERE userId=?",userId);
        if(rst.next()){
//            dto.setUserId(rst.getString(1));
//            dto.setPost(rst.getString(2));
//            dto.setName(rst.getString(3));
//            dto.setBranch(rst.getString(4));
//            dto.setPassword(rst.getString(5));
        }
        return new User(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
    }



    public  List<User> getAll() throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM user";
//        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet rst=SQLUtil.execute("SELECT * FROM user");
        ArrayList<User> dtoList=new ArrayList<>();
        while (rst.next()){
            dtoList.add(new User(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));
//            UserDto dto=new UserDto();
//            dto.setUserId(rst.getString(1));
//            dto.setPost(rst.getString(2));
//            dto.setName(rst.getString(3));
//            dto.setBranch(rst.getString(4));
//            dto.setPassword(rst.getString(5));
//            dtoList.add(dto);
        }
        return dtoList;
    }

    public  String generateNextUserId() throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT userId FROM user ORDER BY userId DESC LIMIT 1";
//        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet rst=SQLUtil.execute("SELECT userId FROM user ORDER BY userId DESC LIMIT 1");
        if(rst.next()){
            return String.format("U%03d", Integer.parseInt(rst.getString(1).substring(1))+1);
        }
        return "U001";
    }
}
