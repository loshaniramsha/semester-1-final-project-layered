package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Schedule;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.ScheduleDto;

import java.util.List;

public interface ScheduleBO extends SuperBO {
    boolean saveSchedule(ScheduleDto dto) throws Exception ;
    boolean deleteSchedule(String scheduleId) throws Exception  ;
    boolean updateSchedule(ScheduleDto dto) throws Exception ;
    ScheduleDto searchSchedule(String scheduleId)  throws Exception;
    List<ScheduleDto> getAllSchedule() throws Exception;
}
