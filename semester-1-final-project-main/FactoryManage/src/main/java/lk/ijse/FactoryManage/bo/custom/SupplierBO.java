package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Supplier;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.SupplierDto;

import java.util.List;

public interface SupplierBO extends SuperBO {
    boolean saveSupplier(SupplierDto dto) throws Exception ;
    boolean deleteSupplier(String supplierId) throws Exception  ;
    boolean updateSupplier(SupplierDto dto) throws Exception ;
    SupplierDto searchSupplier(String supplierId)  throws Exception;
    List<SupplierDto> getAllSupplier() throws Exception;
}
