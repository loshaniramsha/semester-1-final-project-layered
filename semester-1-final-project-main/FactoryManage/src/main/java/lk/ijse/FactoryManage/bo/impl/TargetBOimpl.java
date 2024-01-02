package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.Target;
import lk.ijse.FactoryManage.bo.custom.TargetBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.TargetDAO;
import lk.ijse.FactoryManage.dto.TargetDto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TargetBOimpl implements TargetBO {
    TargetDAO targetDAO= (TargetDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TARGET);
    public  boolean saveTarget(TargetDto dto) throws Exception {

        return targetDAO.save(new Target(dto.getTargetId(),dto.getTargetAmount(),dto.getReceiveDate(),dto.getSendDate()));
    }

    public  boolean deleteTarget(String targetId) throws Exception {

        return targetDAO.delete(targetId);
    }

    public  boolean updateTarget(TargetDto dto) throws Exception {

        return targetDAO.update(new Target(dto.getTargetId(),dto.getTargetAmount(),dto.getReceiveDate(),dto.getSendDate()));
    }

    public  TargetDto searchTarget(String targetId) throws Exception {
     Target target = targetDAO.search(targetId);
        return new TargetDto(target.getTargetId(),target.getTargetAmount(),target.getReceiveDate(),target.getSendDate());
    }


    public List<TargetDto> getAllTarget() throws Exception {
        List<Target> all = targetDAO.getAll();
        List<TargetDto> allTargets = new ArrayList<>();
        for (Target target : all) {
            allTargets.add(new TargetDto(target.getTargetId(),target.getTargetAmount(),target.getReceiveDate(),target.getSendDate()));
        }
        return allTargets;
    }
}
