package lk.ijse.FactoryManage.dao.custom;

import lk.ijse.FactoryManage.Entity.User;
import lk.ijse.FactoryManage.dao.CrudDAO;

public interface UserDAO extends CrudDAO<User> {
     String generateNextUserId() throws Exception;
}
