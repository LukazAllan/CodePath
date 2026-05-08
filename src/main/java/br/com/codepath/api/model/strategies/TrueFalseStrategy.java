package br.com.codepath.api.model.strategies;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.model.TrueFalse;
import br.com.codepath.api.model.enums.QuestionType;
import br.com.codepath.api.model.interfaces.IQuestion;
import br.com.codepath.api.repository.TrueFalseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TrueFalseStrategy implements IQuestion {

    @Autowired
    TrueFalseRepository trueFalseRepository;

    @Override
    public Map<String, String> getQuestionById(Long id) {

        TrueFalse tf = trueFalseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sem TrueFalse"));

        return Map.of(
                "question", tf.getQuestion().getBody(),
                "type", QuestionType.TRUE_FALSE.name(),
                "option1", tf.getTrueAnswer(),
                "option2", tf.getFalseAnswer()
        );
    }

    @Override
    public Boolean verifyQuestionById(Long id, Answer answer) {

        TrueFalse tf = trueFalseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sem TrueFalse"));

        // segurança básica (evita NullPointerException)
        if (tf.getValue() == 0) {
            return answer.getBody().equalsIgnoreCase(tf.getFalseAnswer());
        } else {
            return answer.getBody().equalsIgnoreCase(tf.getTrueAnswer());
        }
    }
}