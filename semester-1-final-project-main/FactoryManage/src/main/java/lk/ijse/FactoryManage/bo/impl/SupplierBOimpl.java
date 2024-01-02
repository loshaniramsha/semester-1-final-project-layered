package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.Supplier;
import lk.ijse.FactoryManage.bo.custom.SupplierBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.SupplierDAO;
import lk.ijse.FactoryManage.dto.SupplierDto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOimpl implements SupplierBO {
    SupplierDAO supplierDAO= (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    public  boolean saveSupplier(SupplierDto dto) throws Exception {

        return supplierDAO.save(new Supplier(dto.getSupplierId(),dto.getName(),dto.getAmmountbrought(),dto.getDate()));
    }

    public  boolean deleteSupplier(String supId) throws Exception {

        return supplierDAO.delete(supId);
    }



    public  SupplierDto searchSupplier(String supId) throws Exception {
        Supplier supplier = supplierDAO.search(supId);
        return new SupplierDto(supplier.getSupplierId(),supplier.getName(),supplier.getAmmountbrought(),supplier.getDate());
    }

    public  boolean updateSupplier(SupplierDto dto) throws Exception {
        return supplierDAO.update(new Supplier(dto.getSupplierId(),dto.getName(),dto.getAmmountbrought(),dto.getDate()));
    }

    public  List<SupplierDto> getAllSupplier() throws Exception {
       List<Supplier> all = supplierDAO.getAll();
        List<SupplierDto> list=new ArrayList<>();
        for (Supplier supplier : all) {
            list.add(new SupplierDto(supplier.getSupplierId(),supplier.getName(),supplier.getAmmountbrought(),supplier.getDate()));
        }
        return list;
    }


}
