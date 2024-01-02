package lk.ijse.FactoryManage.dao.custom;

import lk.ijse.FactoryManage.Entity.Exportable;
import lk.ijse.FactoryManage.Entity.Product;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.Madeproductdto;
import lk.ijse.FactoryManage.dto.ProductDto;

import java.util.List;

public interface ProductDAO extends CrudDAO<Product> {
     boolean saveMadeProduct(Madeproductdto dto) throws Exception;
     boolean updateMadeProduct(Madeproductdto dto) throws Exception;
     boolean updateQuantity(Exportable dto) throws Exception;
     //  List<ProductDto> getAllIds() throws Exception;
}
