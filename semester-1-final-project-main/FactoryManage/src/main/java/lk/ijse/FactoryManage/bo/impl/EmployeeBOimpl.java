package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.Employee;
import lk.ijse.FactoryManage.bo.custom.EmployeeBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.EmployeeDAO;
import lk.ijse.FactoryManage.dto.EmployeeDto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOimpl implements EmployeeBO {
    EmployeeDAO employeeDAO= (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    public  boolean saveEmployee(EmployeeDto dto) throws Exception {
        return employeeDAO.save(new Employee(dto.getEmployeeId(),dto.getName(),dto.getType(),dto.getEmail(),dto.getPhone(),dto.getUserId(),dto.getScheduleId()));
    }



    public  boolean deleteEmployee(String employeeId) throws Exception  {
        return employeeDAO.delete(employeeId);
    }



    public  boolean updateEmployee(EmployeeDto dto) throws Exception {
        return employeeDAO.update(new Employee(dto.getEmployeeId(),dto.getName(),dto.getType(),dto.getEmail(),dto.getPhone(),dto.getUserId(),dto.getScheduleId()));
    }

    public EmployeeDto searchEmployee(String employeeId)  throws Exception {
        Employee employee = employeeDAO.search(employeeId);
        return new EmployeeDto(employee.getEmployeeId(), employee.getName(), employee.getType(), employee.getEmail(), employee.getPhone(), employee.getUserId(), employee.getScheduleId());
    }



    public List<EmployeeDto> getAllEmployee() throws Exception {
        List<Employee> list = employeeDAO.getAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee : list) {
            employeeDtoList.add(new EmployeeDto(employee.getEmployeeId(), employee.getName(), employee.getType(), employee.getEmail(), employee.getPhone(), employee.getUserId(), employee.getScheduleId()));
        }
        return employeeDtoList;
    }
}

