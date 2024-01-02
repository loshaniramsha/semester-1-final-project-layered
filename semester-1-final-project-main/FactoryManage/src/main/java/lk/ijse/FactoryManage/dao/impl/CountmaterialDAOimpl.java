package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.Countmaterial;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.CountmaterialDAO;
import lk.ijse.FactoryManage.db.DbConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CountmaterialDAOimpl implements CountmaterialDAO {
    public  boolean save(Countmaterial dto) throws Exception {
        return SQLUtil.execute("INSERT INTO countmaterial VALUES(?,?,?)", dto.getMaterialId(),dto.getProductId(),dto.getAmmountuse());
       // Connection connection= DbConection.getInstance().getConnection();
//       try {
//            connection.setAutoCommit(false);
//            String sql = "INSERT INTO countmaterial VALUES(?,?,?)";
//            PreparedStatement pstm = connection.prepareStatement(sql);
//           // pstm.setObject(1, countmaterialDto.getMaterialId());
//            pstm.setObject(1, dto.getMaterialId());
//            pstm.setObject(2, dto.getProductId());
//            pstm.setObject(3, dto.getAmmountuse());
//            boolean isSaved = pstm.executeUpdate() > 0;
//            if (isSaved) {
//                boolean isSaved1 = MaterialModel.updateQuantity(dto.getMaterialId(), dto.getAmmountuse());
//                if (isSaved1) {
//                    connection.commit();
//                    return true;
//                }
//            }
//            connection.rollback();
//            return false;
//        }finally {
//           connection.setAutoCommit(true);
       }




    public Countmaterial search(String matirialId) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "SELECT * FROM countmaterial WHERE materialId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, matirialId);
//        CountmaterialDto countmaterialDto = null;
        ResultSet rst = SQLUtil.execute("SELECT * FROM countmaterial WHERE materialId=?", matirialId);
       while (rst.next()) {
//            String materialId = rst.getString(1);
//            String productId = rst.getString(2);
//            String ammountuse = rst.getString(3);
//            countmaterialDto = new CountmaterialDto(materialId, productId, ammountuse);
       }
        return new Countmaterial(rst.getString(1), rst.getString(2), rst.getString(3));

    }




    public  boolean delete(String materialId) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "DELETE FROM countmaterial WHERE materialId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//       pstm.setObject(1, materialId);
        return SQLUtil.execute("DELETE FROM countmaterial WHERE materialId=?", materialId);
    }



    public  boolean update(Countmaterial dto) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "UPDATE countmaterial SET productId=?, ammountuse=? WHERE materialId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, dto.getProductId());
//        pstm.setObject(2, dto.getAmmountuse());
//        pstm.setObject(3, dto.getMaterialId());
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("UPDATE countmaterial SET productId=?, ammountuse=? WHERE materialId=?",dto.getProductId(),dto.getAmmountuse(),dto.getMaterialId());
    }

    public List<Countmaterial> getAll() throws Exception {
      //  Connection connection = DbConection.getInstance().getConnection();
      //  String sql = "SELECT * FROM countmaterial";
      //  PreparedStatement pstm = connection.prepareStatement(sql);
       // ResultSet rst = pstm.executeQuery();
        ResultSet rst = SQLUtil.execute("SELECT * FROM countmaterial");
        List<Countmaterial> list = new ArrayList<>();
        while (rst.next()) {
//            String materialId = rst.getString(1);
//            String productId = rst.getString(2);
//            String ammountuse = rst.getString(3);
//            list.add(new Countmaterial(materialId, productId, ammountuse));
            Countmaterial entity = new Countmaterial(rst.getString(1), rst.getString(2), rst.getString(3));
        }
        return list;
    }



}
