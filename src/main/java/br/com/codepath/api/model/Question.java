package br.com.codepath.api.model;

import br.com.codepath.api.model.enums.QuestionType;
import br.com.codepath.api.model.Lesson;
import jakarta.annotation.Nullable;
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

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @ManyToOne
    @JoinColumn(name = "lessonId")
    private Lesson lesson;

    private String label;

    private String prompt;

    @Nullable
    private String code;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> options;

    private Integer correct;

    private String hint;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<MatchingPair> pairs;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> acceptedAnswers;

}
