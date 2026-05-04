package br.com.codepath.api.model.strategies;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.model.Question;
import br.com.codepath.api.model.enums.QuestionType;
import br.com.codepath.api.model.interfaces.IQuestion;

import java.util.Map;

public class TrueFalseStrategy implements IQuestion {

    @Override
    public Map<String, String> getQuestion(Question question) {
        return Map.of(
                "question", question.getBody(),
                "type", QuestionType.TRUE_FALSE.name(),
                "option1", "true",
                "option2", "false"
        );
    }

    @Override
    public Boolean verifyQuestion(Question question, Answer answer) {

        // segurança básica (evita NullPointerException)
        if (answer == null || answer.getOption() == null) {
            return false;
        }
        return answer.getOption().getIsCorrect();
    }
}