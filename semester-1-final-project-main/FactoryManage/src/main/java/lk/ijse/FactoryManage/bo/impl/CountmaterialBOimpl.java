package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.Countmaterial;
import lk.ijse.FactoryManage.bo.custom.CountmaterialBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.CountmaterialDAO;
import lk.ijse.FactoryManage.dao.custom.MaterialDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
//import lk.ijse.FactoryManage.model.MaterialModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CountmaterialBOimpl implements CountmaterialBO {
    CountmaterialDAO countmaterialDAO= (CountmaterialDAO) DAOFactory.getDaoFactory().getDAO((DAOFactory.DAOTypes.COUNTMATERIAL));
    MaterialDAO materialDAO= (MaterialDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MATERIAL);
    public  boolean saveCountmaterial(CountmaterialDto dto) throws Exception {
        Connection connection= DbConection.getInstance().getConnection();
       try {
            connection.setAutoCommit(false);
//            String sql = "INSERT INTO countmaterial VALUES(?,?,?)";
//            PreparedStatement pstm = connection.prepareStatement(sql);
//           // pstm.setObject(1, countmaterialDto.getMaterialId());
//            pstm.setObject(1, dto.getMaterialId());
//            pstm.setObject(2, dto.getProductId());
//            pstm.setObject(3, dto.getAmmountuse());
//            boolean isSaved = pstm.executeUpdate() > 0;
            boolean isSaved = countmaterialDAO.save(new Countmaterial(dto.getMaterialId(),dto.getProductId(),dto.getAmmountuse()));
            if (isSaved) {
                boolean isSaved1 = materialDAO.updateQuantity(dto.getMaterialId(), dto.getAmmountuse());
                if (isSaved1) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        }finally {
           connection.setAutoCommit(true);
       }
    }



    public CountmaterialDto searchCountmaterial(String matirialId) throws Exception {
      Countmaterial countmaterial= countmaterialDAO.search(matirialId);
        return new CountmaterialDto(countmaterial.getMaterialId(),countmaterial.getProductId(),countmaterial.getAmmountuse());

    }




    public  boolean deleteCountmaterial(String materialId) throws Exception {

        return countmaterialDAO.delete(materialId);
    }



    public  boolean updateCountmaterial(CountmaterialDto dto) throws Exception {

        return countmaterialDAO.update(new Countmaterial(dto.getMaterialId(),dto.getProductId(),dto.getAmmountuse()));
    }

    public List<CountmaterialDto> getAllCountmaterial() throws Exception {
        List<Countmaterial> list = countmaterialDAO.getAll();
        List<CountmaterialDto> dtoList = new ArrayList<>();
            for (Countmaterial countmaterial : list) {
                dtoList.add(new CountmaterialDto(countmaterial.getMaterialId(),countmaterial.getProductId(),countmaterial.getAmmountuse()));
            }
        return dtoList;
    }



}
