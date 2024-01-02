package lk.ijse.FactoryManage.dto;

import lk.ijse.FactoryManage.Entity.Target;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TargetDto extends Target {
    private String targetId;
    private String targetAmount;
    private String receiveDate;
    private String sendDate;
}
