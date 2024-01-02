package lk.ijse.FactoryManage.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Exportable {
    private String targetId;
    private String productId;
    private String status;
    private String Exportableqty;
    private String  amountexport;
}
