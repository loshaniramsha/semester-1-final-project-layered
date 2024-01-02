package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.Material;
import lk.ijse.FactoryManage.bo.custom.MaterialBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.MaterialDAO;
import lk.ijse.FactoryManage.dto.Madeproductdto;
import lk.ijse.FactoryManage.dto.MaterialDto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaterialBOimpl implements MaterialBO {
    MaterialDAO materialDAO= (MaterialDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MATERIAL);


public boolean saveMaterial(MaterialDto dto) throws Exception {
    return materialDAO.save(new Material(dto.getMaterialId(),dto.getNameOfType(),dto.getQty(),dto.getSupplierId()));
}
//    public  boolean updateMaterial(String materialId, String ammountuse) throws Exception {
//        return MaterialDAO.update(new Material(materialId,ammountuse));
//
//    }

    public  boolean deleteMaterial(String materialId) throws Exception {
         return materialDAO.delete(materialId);

    }


    public  boolean updateMaterial(MaterialDto dto) throws Exception {
          return materialDAO.update(new Material(dto.getMaterialId(),dto.getNameOfType(),dto.getQty(),dto.getSupplierId()));

    }

    public  MaterialDto searchMaterial(String materialId) throws Exception {
           Material material = materialDAO.search(materialId);
           return new MaterialDto(material.getMaterialId(),material.getNameOfType(),material.getQty(),material.getSupplierId());
    }

    public List<MaterialDto> getAllMaterial() throws Exception {
        List<Material> all = materialDAO.getAll();
        List<MaterialDto> list=new ArrayList<>();
        for (Material material : all) {
            list.add(new MaterialDto(material.getMaterialId(),material.getNameOfType(),material.getQty(),material.getSupplierId()));
        }
        return list;
    }
}
