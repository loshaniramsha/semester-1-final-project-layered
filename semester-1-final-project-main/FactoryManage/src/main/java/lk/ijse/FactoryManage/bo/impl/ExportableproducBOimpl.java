package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.Exportable;
import lk.ijse.FactoryManage.bo.custom.ExportableproductBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.ExportableproductDAO;
import lk.ijse.FactoryManage.dao.custom.ProductDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.ExportableDto;
import lk.ijse.FactoryManage.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExportableproducBOimpl implements ExportableproductBO {

    ExportableproductDAO exportableproductDAO = (ExportableproductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EXPORTABLE);
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    public boolean saveExportable(ExportableDto dto) throws Exception {

        Connection connection = DbConection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);

            boolean isExProductSaved = exportableproductDAO.save(new Exportable(
                    dto.getTargetId(),dto.getProductId(),dto.getStatus(),dto.getExportableqty(),dto.getAmountexport()));
            if (isExProductSaved) {
                boolean isProductUpdated = productDAO.updateQuantity(new Exportable(
                        dto.getTargetId(),dto.getProductId(),dto.getStatus(),dto.getExportableqty(),dto.getAmountexport()));
                if (isProductUpdated){
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

    public boolean deleteExportable(String targetId) throws Exception {

        return exportableproductDAO.delete(targetId);
    }

    public boolean updateExportable(ExportableDto dto) throws Exception {
        //return exportableproductDAO.update(dto);
        return exportableproductDAO.update(new Exportable(
                dto.getTargetId(),dto.getProductId(),dto.getStatus(),dto.getExportableqty(),dto.getAmountexport()
        ));
    }

    public ExportableDto searchExportable(String targetId) throws Exception{
         Exportable exportable=exportableproductDAO.search(targetId);
        return new ExportableDto(exportable.getTargetId(),exportable.getProductId(),exportable.getStatus(),exportable.getExportableqty(),exportable.getAmountexport());
    }

    public List<ExportableDto> getAllExportable() throws Exception {
         List<Exportable> list = exportableproductDAO.getAll();
        List<ExportableDto> dtoList=new ArrayList<>();
        for (Exportable exportable : list) {
            dtoList.add(new ExportableDto(exportable.getTargetId(),exportable.getProductId(),exportable.getStatus(),exportable.getExportableqty(),exportable.getAmountexport()));
        }
        return dtoList;
    }


}
