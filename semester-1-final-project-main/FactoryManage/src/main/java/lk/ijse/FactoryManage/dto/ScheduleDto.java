package lk.ijse.FactoryManage.dto;

import lk.ijse.FactoryManage.Entity.Schedule;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ScheduleDto extends Schedule {
    private String scheduleId;
    private String type;
    private String date;
    private String plane;
}
