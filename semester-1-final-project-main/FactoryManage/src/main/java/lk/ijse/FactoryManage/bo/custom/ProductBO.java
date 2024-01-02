package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Product;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.ExportableDto;
import lk.ijse.FactoryManage.dto.Madeproductdto;
import lk.ijse.FactoryManage.dto.ProductDto;

import java.util.List;

public interface ProductBO extends SuperBO {
    boolean saveProduct(ProductDto dto) throws Exception ;
    boolean deleteProduct(String productId) throws Exception  ;
    boolean updateProduct(ProductDto dto) throws Exception ;
    ProductDto searchProduct(String productId)  throws Exception;
    List<ProductDto> getAllProduct() throws Exception;
     boolean updateQuantity(ExportableDto dto) throws Exception;
     boolean saveMadeProduct(Madeproductdto dto) throws Exception;
    boolean updateMadeProduct(Madeproductdto dto) throws Exception;

}
