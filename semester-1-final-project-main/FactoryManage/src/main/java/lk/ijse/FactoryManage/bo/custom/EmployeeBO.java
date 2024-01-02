package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Employee;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.EmployeeDto;

import java.util.List;

public interface EmployeeBO extends SuperBO {
    boolean saveEmployee(EmployeeDto dto) throws Exception ;
    boolean deleteEmployee(String employeeId) throws Exception  ;
    boolean updateEmployee(EmployeeDto dto) throws Exception ;
    EmployeeDto searchEmployee(String employeeId)  throws Exception;
    List<EmployeeDto> getAllEmployee() throws Exception;
}
