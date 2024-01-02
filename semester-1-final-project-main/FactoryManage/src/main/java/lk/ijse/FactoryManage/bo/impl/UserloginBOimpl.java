package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.bo.custom.UserloginBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.custom.UserloginDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.UserDto;
import lk.ijse.FactoryManage.dto.UserloginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserloginBOimpl implements UserloginBO {
    UserloginDAO userloginDAO= (UserloginDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USERLOGIN);

    public  boolean verifyUser(UserloginDto userloginDto) throws Exception {
        if (userloginDto.getPassword() == null) {
            return false;
        }
        Connection connection= DbConection.getInstance().getConnection();
        String sql="SELECT * FROM user WHERE name=?";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,userloginDto.getUserName());
        UserDto findedUser=null;
        ResultSet rst=pstm.executeQuery();
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
