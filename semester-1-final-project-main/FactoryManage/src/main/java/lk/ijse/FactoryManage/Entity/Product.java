package lk.ijse.FactoryManage.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private String productId;
    private String name;
    private String brand;
    private String qty;
}
