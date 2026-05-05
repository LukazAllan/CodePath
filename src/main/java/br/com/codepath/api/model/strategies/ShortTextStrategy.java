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
    public Map<String, String> getQuestion(Long id) {

        Optional<ShortAnswer> sa = shortAnswerRepository.findById(id);

        return Map.of(
                "question", shortAnswerRepository.findById(id),
                "type", QuestionType.SHORT_TEXT.name(),
                "answer", Answer.
        );
    }

    @Override
    public Boolean verifyQuestion(Question question, Answer answer) {
        return null;
    }
}
