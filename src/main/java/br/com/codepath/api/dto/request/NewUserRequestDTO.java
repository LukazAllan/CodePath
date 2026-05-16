package br.com.codepath.api.dto.request;

import lombok.Data;

@Data
public class NewUserRequestDTO {
    private String name;
    private String email;
    private String password;
}
