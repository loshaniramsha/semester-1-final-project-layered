package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.User;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.UserDto;

import java.util.List;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDto dto) throws Exception ;
    boolean deleteUser(String userId) throws Exception  ;
    boolean updateUser(UserDto dto) throws Exception ;
    UserDto searchUser(String userId)  throws Exception;
    List<UserDto> getAllUser() throws Exception;
    String generateNextUserId() throws Exception;

}
