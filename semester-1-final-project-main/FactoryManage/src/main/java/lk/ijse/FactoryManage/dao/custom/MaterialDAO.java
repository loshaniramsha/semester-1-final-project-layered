package lk.ijse.FactoryManage.dao.custom;

import lk.ijse.FactoryManage.Entity.Material;
import lk.ijse.FactoryManage.dao.CrudDAO;

public interface MaterialDAO extends CrudDAO<Material> {
    boolean updateQuantity(String materialId, String ammountuse)throws Exception;
}
