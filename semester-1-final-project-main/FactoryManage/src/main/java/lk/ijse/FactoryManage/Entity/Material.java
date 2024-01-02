package lk.ijse.FactoryManage.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Material {
   // public Object cmbSupplierId;
    private String materialId;
    private String nameOfType;
    private String qty;
    private String supplierId;


}