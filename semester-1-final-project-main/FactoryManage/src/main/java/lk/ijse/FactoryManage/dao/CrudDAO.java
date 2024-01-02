package lk.ijse.FactoryManage.dao;

import lk.ijse.FactoryManage.Entity.Employee;
import lk.ijse.FactoryManage.dto.EmployeeDto;
import lk.ijse.FactoryManage.dto.ExportableDto;

import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
      boolean save(T dto) throws Exception;

     boolean delete(String Id) throws Exception ;

     boolean update(T dto) throws Exception ;
    T search(String Id)  throws Exception ;

     List<T> getAll() throws Exception ;
}
