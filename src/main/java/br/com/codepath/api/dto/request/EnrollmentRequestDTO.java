package br.com.codepath.api.dto.request;

import lombok.Data;

@Data
public class EnrollmentRequestDTO {
    private Long userId;
    private Long courseId;
}