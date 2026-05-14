package br.com.codepath.api.model;

import br.com.codepath.api.model.enums.QuestionType;
import br.com.codepath.api.model.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table (name= "question")
@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @Enumerated(EnumType.STRING)
    private QuestionType Type;

    @ManyToOne
    @JoinColumn(name = "lessonId")
    private Lesson lesson;
}
