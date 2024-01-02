package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Countmaterial;
import lk.ijse.FactoryManage.Entity.Employee;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dto.CountmaterialDto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface CountmaterialBO extends SuperBO {
      boolean saveCountmaterial(CountmaterialDto dto) throws Exception ;
      boolean deleteCountmaterial(String countmaterialId) throws Exception  ;
      boolean updateCountmaterial(CountmaterialDto dto) throws Exception ;
      CountmaterialDto searchCountmaterial(String countmaterialId)  throws Exception;
      List<CountmaterialDto> getAllCountmaterial() throws Exception;
}
