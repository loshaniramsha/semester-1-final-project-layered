package lk.ijse.FactoryManage.dto;

import lk.ijse.FactoryManage.Entity.User;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserDto extends User {
    private String userId;
    private String post;
    private String name;
    private String branch;
    private String password;
}
