package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Target;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.TargetDto;

import java.util.List;

public interface TargetBO extends SuperBO {
    boolean saveTarget(TargetDto dto) throws Exception ;
    boolean deleteTarget(String targetId) throws Exception  ;
    boolean updateTarget(TargetDto dto) throws Exception ;
    TargetDto searchTarget(String targetId)  throws Exception;
    List<TargetDto> getAllTarget() throws Exception;
}
