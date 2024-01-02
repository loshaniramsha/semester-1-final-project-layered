package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.Material;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.MaterialDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.MaterialDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAOimpl implements MaterialDAO {
    public  boolean save(Material dto) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="INSERT INTO material VALUES(?,?,?,?)";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getMaterialId());
//        pstm.setObject(2,dto.getNameOfType());
//        pstm.setObject(3,dto.getQty());
//        pstm.setObject(4,dto.getSupplierId());
//        boolean isSaved=pstm.executeUpdate()>0;
        return SQLUtil.execute("INSERT INTO material VALUES(?,?,?,?)",dto.getMaterialId(),dto.getNameOfType(),dto.getQty(),dto.getSupplierId());
    }


    public  boolean updateQuantity(String materialId, String ammountuse) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="UPDATE material SET qty=qty-? WHERE materialId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,materialId);
//        pstm.setObject(2,Integer.parseInt(ammountuse));
        return SQLUtil.execute("UPDATE material SET qty=qty-? WHERE materialId=?",ammountuse,materialId);
    }

    public  boolean delete(String materialId) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="DELETE FROM material WHERE materialId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,materialId);
        return SQLUtil.execute("DELETE FROM material WHERE materialId=?",materialId);
    }


    public  boolean update(Material dto) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="UPDATE material SET nameOfType=?,qty=?,supplierId=? WHERE materialId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getNameOfType());
//        pstm.setObject(2,dto.getQty());
//        pstm.setObject(3,dto.getSupplierId());
//        pstm.setObject(4,dto.getMaterialId());
        return SQLUtil.execute("UPDATE material SET nameOfType=?,qty=?,supplierId=? WHERE materialId=?",dto.getNameOfType(),dto.getQty(),dto.getSupplierId(),dto.getMaterialId());
    }

    public  Material search(String materialId) throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM material WHERE materialId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,materialId);
        ResultSet rst=SQLUtil.execute("SELECT * FROM material WHERE materialId=?",materialId);
        if (rst.next()){
            return new Material(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;
    }

    public List<Material> getAll() throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM material";
//        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet rst=SQLUtil.execute("SELECT * FROM material");
        List<Material> list=new ArrayList<>();
        while (rst.next()){
            list.add(new Material(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));
        }
        return list;
    }
}
