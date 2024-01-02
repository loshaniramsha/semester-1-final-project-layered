package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.UserloginDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.UserDto;
import lk.ijse.FactoryManage.dto.UserloginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserloginDAOimpl implements UserloginDAO {

    public  boolean verifyUser(UserloginDto userloginDto) throws Exception {
        if (userloginDto.getPassword() == null) {
            return false;
        }
        UserDto findedUser=null;
        ResultSet rst= SQLUtil.execute("SELECT * FROM user WHERE name=?",userloginDto.getUserName());
        if(rst.next()){
            findedUser=new UserDto(
              rst.getString(1),
              rst.getString(2),
              rst.getString(3),
              rst.getString(4),
              rst.getString(5)
            );
        }
        if (findedUser!=null){
            if (findedUser.getPassword() != null && findedUser.getPassword().equals(userloginDto.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
