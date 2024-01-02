package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Material;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.MaterialDto;

import java.util.List;

public interface MaterialBO extends SuperBO {
    boolean saveMaterial(MaterialDto dto) throws Exception ;
    boolean deleteMaterial(String materialId) throws Exception  ;
    boolean updateMaterial(MaterialDto dto) throws Exception ;
    MaterialDto searchMaterial(String materialId)  throws Exception;
    List<MaterialDto> getAllMaterial() throws Exception;
}
