package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.Supplier;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.SupplierDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOimpl implements SupplierDAO {
    public  boolean save(Supplier dto) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="INSERT INTO supplier VALUES(?,?,?,?)";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getSupplierId());
//        pstm.setObject(2,dto.getName());
//        pstm.setObject(3,dto.getAmmountbrought());
//        pstm.setObject(4,dto.getDate());
//        boolean isSaved=pstm.executeUpdate()>0;
        return SQLUtil.execute("INSERT INTO supplier VALUES(?,?,?,?)",dto.getSupplierId(),dto.getName(),dto.getAmmountbrought(),dto.getDate());
    }

    public  boolean delete(String supId) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="DELETE FROM supplier WHERE supplierId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,supId);
//        boolean isDeleted=pstm.executeUpdate()>0;
        return SQLUtil.execute("DELETE FROM supplier WHERE supplierId=?",supId);
    }



    public  Supplier search(String supId) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM supplier WHERE supplierId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,supId);
//        Supplier dto=new Supplier();
        ResultSet rst=SQLUtil.execute("SELECT * FROM supplier WHERE supplierId=?",supId);
        if(rst.next()){
//            dto.setSupplierId(rst.getString(1));
//            dto.setName(rst.getString(2));
//            dto.setAmmountbrought(rst.getString(3));
//            dto.setDate(rst.getString(4));
        }
        return new Supplier(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
    }

    public  boolean update(Supplier dto) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="UPDATE supplier SET name=?,ammountbrought=?,date=? WHERE supplierId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getSupplierId());
//        pstm.setObject(2,dto.getName());
//        pstm.setObject(3,dto.getAmmountbrought());
//        pstm.setObject(4,dto.getDate());
        return SQLUtil.execute("UPDATE supplier SET name=?,ammountbrought=?,date=? WHERE supplierId=?",dto.getSupplierId(),dto.getName(),dto.getAmmountbrought(),dto.getDate());
    }

    public  List<Supplier> getAll() throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        PreparedStatement pstm=connection.prepareStatement("SELECT * FROM supplier");
        ResultSet rst=SQLUtil.execute("SELECT * FROM supplier");
        List<Supplier> list=new ArrayList<>();
        while (rst.next()){
            list.add(new Supplier(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
            //list.add(new Supplier(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return list;
    }


}
