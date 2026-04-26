package br.com.codepath.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ShortAnswer")
@NoArgsConstructor
@AllArgsConstructor
public class ShortAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "questionId")
    private Question question;

    private String text;
    private Boolean isCorrect;

}
