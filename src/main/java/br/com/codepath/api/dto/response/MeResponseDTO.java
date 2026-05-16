package br.com.codepath.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeResponseDTO {
    private String name;
    private String email;
    private String token;
    private LocalDateTime lastActivity;
}
