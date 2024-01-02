package lk.ijse.FactoryManage.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Schedule {
    private String scheduleId;
    private String type;
    private String date;
    private String plane;
}
