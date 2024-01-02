package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.User;
import lk.ijse.FactoryManage.bo.custom.UserBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.UserDAO;
import lk.ijse.FactoryManage.dto.UserDto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserBOimpl implements UserBO {
    UserDAO userDAO= (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    public  boolean saveUser(   UserDto dto) throws Exception {

        return userDAO.save(new User(dto.getUserId(),dto.getPost(),dto.getName(),dto.getBranch(),dto.getPassword()));

    }

    public  boolean deleteUser(String userId) throws Exception {

        return userDAO.delete(userId);

    }

    public  boolean updateUser(UserDto dto) throws Exception {

        return userDAO.update(new User(dto.getUserId(),dto.getPost(),dto.getName(),dto.getBranch(),dto.getPassword()));
    }

    public  UserDto searchUser(String userId) throws Exception {
         User rst = userDAO.search(userId);
        return new UserDto(rst.getUserId(),rst.getPost(),rst.getName(),rst.getBranch(),rst.getPassword());
    }



    public  List<UserDto> getAllUser() throws Exception {
        List<User> rst = userDAO.getAll();
        ArrayList<UserDto> dtoList=new ArrayList<>();
        for (User user : rst) {
            dtoList.add(new UserDto(user.getUserId(),user.getPost(),user.getName(),user.getBranch(),user.getPassword()));
        }
        return dtoList;
    }

    public  String generateNextUserId() throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT userId FROM user ORDER BY userId DESC LIMIT 1";
//        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet rst=SQLUtil.execute("SELECT userId FROM user ORDER BY userId DESC LIMIT 1");
        if(rst.next()){
            return String.format("U%03d", Integer.parseInt(rst.getString(1).substring(1))+1);
        }
        return "U001";
    }
}
