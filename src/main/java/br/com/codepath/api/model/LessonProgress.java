package br.com.codepath.api.model;

import br.com.codepath.api.model.enums.LessonProgressStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lesson_progress")
public class LessonProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Enumerated(EnumType.STRING)
    private LessonProgressStatus status;

    private Boolean completed;
    private LocalDateTime completedAt;
}
