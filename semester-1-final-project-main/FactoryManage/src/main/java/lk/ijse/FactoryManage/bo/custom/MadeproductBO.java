package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Madeproduct;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.Madeproductdto;

import java.util.List;

public interface MadeproductBO extends SuperBO {
    boolean saveMadeproduct(Madeproductdto dto) throws Exception ;
    boolean deleteMadeproduct(String productId) throws Exception  ;
    boolean updateMadeproduct(Madeproductdto dto) throws Exception ;
    Madeproductdto searchMadeProduct(String productId) throws Exception;
    List<Madeproductdto> getAllMadeproduct() throws Exception;



}
