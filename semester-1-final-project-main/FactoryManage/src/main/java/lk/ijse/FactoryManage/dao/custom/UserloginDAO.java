package lk.ijse.FactoryManage.dao.custom;

import lk.ijse.FactoryManage.Entity.Userlogin;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.UserloginDto;

public interface UserloginDAO  {
     boolean verifyUser(UserloginDto userloginDto) throws Exception;
}
