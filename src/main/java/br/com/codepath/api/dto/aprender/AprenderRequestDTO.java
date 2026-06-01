package br.com.codepath.api.dto.aprender;

import lombok.Data;

@Data
public class AprenderRequestDTO {
    private Long userId;
    private Integer courseId;
}
