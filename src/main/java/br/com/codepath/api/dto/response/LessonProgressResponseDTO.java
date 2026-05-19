package br.com.codepath.api.dto.response;

import br.com.codepath.api.model.LessonProgress;
import br.com.codepath.api.model.enums.LessonProgressStatus;

import java.time.LocalDateTime;

public record LessonProgressResponseDTO(
        Long id,
        Long userId,
        Long lessonId,
        LessonProgressStatus status,
        Boolean completed,
        LocalDateTime completedAt
) {
}
