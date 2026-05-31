package br.com.codepath.api.dto.response;

import br.com.codepath.api.model.enums.LessonProgressStatus;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class LessonProgressResponseDTO {
    private Long id;
    private Long userId;
    private Long lessonId;
    private LessonProgressStatus status;
    private Boolean completed;
    private LocalDateTime completedAt;
}
