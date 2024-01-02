package lk.ijse.FactoryManage.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Target {
    private String targetId;
    private String targetAmount;
    private String receiveDate;
    private String sendDate;
}
