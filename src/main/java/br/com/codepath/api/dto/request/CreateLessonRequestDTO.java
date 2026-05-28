package br.com.codepath.api.dto.request;

import lombok.Data;

@Data
public class CreateLessonRequestDTO {
    String name;
    String content;
    Long sectionId;
    Integer ordem;
    Boolean active;
}
