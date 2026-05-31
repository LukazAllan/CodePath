package br.com.codepath.api.dto.aprender;

import java.time.LocalDateTime;

import br.com.codepath.api.model.enums.LessonProgressStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MockProgress{
    private LessonProgressStatus status;
    private Short stars;
    private Boolean completed;
    private LocalDateTime completedAt;
}