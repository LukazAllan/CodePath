package br.com.codepath.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "answermatching")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerMatching {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "anwser_id")
    private Answer answer;

    private String leftValue;

    private String rightValue;
}
