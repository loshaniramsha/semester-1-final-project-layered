package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dto.UserloginDto;

public interface UserloginBO extends SuperBO {
      boolean verifyUser(UserloginDto userloginDto) throws Exception;
}
