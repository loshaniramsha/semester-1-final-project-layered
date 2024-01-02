package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.Madeproduct;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.MadeproductDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.Madeproductdto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MadeproductDAOimpl implements MadeproductDAO {
    @Override
    public boolean save(Madeproduct dto) throws Exception {
        return false;
    }

    public  boolean delete(String productId) throws Exception{
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="DELETE FROM madeproduct WHERE productId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,productId);
//        boolean isDeleted=pstm.executeUpdate()>0;
        return SQLUtil.execute("DELETE FROM madeproduct WHERE productId=?",productId);
    }

    @Override
    public boolean update(Madeproduct dto) throws Exception {
        return false;
    }

       public Madeproduct search(String productId) throws Exception{
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM madeproduct WHERE productId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,productId);
        ResultSet rst=SQLUtil.execute("SELECT * FROM madeproduct WHERE productId=?",productId);
        if (rst.next()){
            return new Madeproduct(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }
        return null;
    }


    public List<Madeproduct> getAll()throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM madeproduct";
//        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet rst=SQLUtil.execute("SELECT * FROM madeproduct");
        List<Madeproduct> list=new ArrayList<>();
        while (rst.next()){
            Madeproductdto entity=new Madeproductdto(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
            //list.add(new Madeproduct(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return list;
    }
}
