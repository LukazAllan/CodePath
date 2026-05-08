package br.com.codepath.api.model.strategies;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.model.Question;
import br.com.codepath.api.model.ShortAnswer;
import br.com.codepath.api.model.enums.QuestionType;
import br.com.codepath.api.model.interfaces.IQuestion;
import br.com.codepath.api.repository.ShortAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Optional;

public class ShortTextStrategy implements IQuestion {

    @Autowired
    ShortAnswerRepository shortAnswerRepository;

    @Override
    public Map<String, String> getQuestionById(Long id) {

        ShortAnswer sa = shortAnswerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sem ShortAnswer"));

        return Map.of(
                "question", sa.getQuestion().getBody(),
                "type", QuestionType.SHORT_TEXT.name(),
                "answer", sa.getText()
        );
    }

    @Override
    public Boolean verifyQuestionById(Long id, Answer answer) {

        ShortAnswer sa = shortAnswerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sem ShortAnswer"));

        return answer.getBody().equalsIgnoreCase(sa.getText());
    }
}
