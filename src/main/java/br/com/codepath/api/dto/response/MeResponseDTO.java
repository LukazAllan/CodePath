package br.com.codepath.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String token;
    private LocalDateTime lastActivity;
}
