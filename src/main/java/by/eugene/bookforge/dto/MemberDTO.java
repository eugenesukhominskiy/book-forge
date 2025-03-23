package by.eugene.bookforge.dto;

import by.eugene.bookforge.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Role role;
    private String email;
    private String username;
    private String password;
}
