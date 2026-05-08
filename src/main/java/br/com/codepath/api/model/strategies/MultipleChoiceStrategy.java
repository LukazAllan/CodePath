package br.com.codepath.api.model.strategies;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.model.Option;
import br.com.codepath.api.model.enums.QuestionType;
import br.com.codepath.api.model.interfaces.IQuestion;
import br.com.codepath.api.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class MultipleChoiceStrategy implements IQuestion {

    @Autowired
    OptionRepository optionRepository;

    @Override
    public Map<String, String> getQuestionById(Long id) {

        List<Option> options = optionRepository.findByQuestionId(id);
        String allOptions = "[";
        for (Option option : options) {
            allOptions = allOptions +"\""+ option.getText() +"\""+ ",";
        }
        allOptions = allOptions.substring(0,allOptions.length()-1)+"]";


        return Map.of(
                "question", options.getFirst().getQuestion().getBody(),
                "type", QuestionType.MULTIPLE_CHOICE.name(),
                "options", allOptions
        );
    }

    @Override
    public Boolean verifyQuestionById(Long id, Answer answer) {
        List<Option> options = optionRepository.findByQuestionId(id);
        for (Option option : options) {
            if(answer.getBody().equals(option.getText()) && option.getIsCorrect()){
                return true;
            }
        }
        return false;
    }
}
