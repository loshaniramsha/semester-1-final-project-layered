package lk.ijse.FactoryManage.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {
    private String userId;
    private String post;
    private String name;
    private String branch;
    private String password;
}
