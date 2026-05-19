package br.com.codepath.api.dto.request;

import lombok.Data;

@Data
public class SectionRequestDTO {
    private Long courseId;
    private String title;
    private String subtitle;
    private String color;
    private char icon;
    private int ordem;
}
