package br.com.codepath.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LessonDTO {
    private Long sectionId;
    private String name;
    private String content;
    private Integer ordem;
}
