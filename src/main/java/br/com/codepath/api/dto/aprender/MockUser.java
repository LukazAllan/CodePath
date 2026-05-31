package br.com.codepath.api.dto.aprender;

import java.time.LocalDateTime;

import br.com.codepath.api.model.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MockUser {
    private String name;
    private String email;
    private String password;
    private Integer xp;
    private Integer hearts;
    private RoleEnum role;
    private LocalDateTime createdAt;
}
