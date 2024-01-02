package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.Schedule;
import lk.ijse.FactoryManage.bo.custom.ScheduleBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.ScheduleDAO;
import lk.ijse.FactoryManage.dto.ScheduleDto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleBOimpl implements ScheduleBO {
    ScheduleDAO scheduleDAO= (ScheduleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SCHEDULE);
    public  boolean saveSchedule(ScheduleDto dto) throws Exception {

        return scheduleDAO.save(new Schedule(dto.getScheduleId(),dto.getType(),dto.getDate(),dto.getPlane()));
    }

    public  boolean deleteSchedule(String scheduleId) throws Exception {

        return scheduleDAO.delete(scheduleId);
    }



    public  boolean updateSchedule(ScheduleDto dto) throws Exception{

       return  scheduleDAO.update(new Schedule(dto.getScheduleId(),dto.getType(),dto.getDate(),dto.getPlane()));
    }

    public  ScheduleDto searchSchedule(String scheduleId) throws Exception {
      Schedule schedule= scheduleDAO.search(scheduleId);

        return new ScheduleDto(schedule.getScheduleId(),schedule.getType(),schedule.getDate(),schedule.getPlane());
    }

    public  List<ScheduleDto> getAllSchedule() throws Exception {
     List<Schedule> all = scheduleDAO.getAll();
        List<ScheduleDto> allSchedules=new ArrayList<>();
      for (Schedule schedule : all) {
          allSchedules.add(new ScheduleDto(schedule.getScheduleId(),schedule.getType(),schedule.getDate(),schedule.getPlane()));
      }
        return allSchedules;
    }
}
