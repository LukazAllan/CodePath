package br.com.codepath.api.dto;

import java.util.List;

import br.com.codepath.api.model.MatchingPair;
import br.com.codepath.api.model.enums.QuestionType;
import lombok.Data;

@Data
public class QuestionDTO {
    private QuestionType type;
    private String label;
    private String prompt;
    private String code;
    private List<String> options;
    private Integer correct;
    private String hint;
    private List<MatchingPair> pairs;
    private List<String> acceptedAnswers;
}
