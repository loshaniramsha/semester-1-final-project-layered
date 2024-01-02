package lk.ijse.FactoryManage.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Madeproduct {

    private String targetAmount;
    private String productId;
    private String employeeId;
    private String completeAmount;
}