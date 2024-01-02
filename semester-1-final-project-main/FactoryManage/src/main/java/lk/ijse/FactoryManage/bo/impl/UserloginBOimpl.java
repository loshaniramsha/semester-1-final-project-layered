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

        return userloginDAO.verifyUser(userloginDto);
    }
}
