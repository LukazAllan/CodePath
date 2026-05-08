package br.com.codepath.api.model.strategies;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.model.MatchingPair;
import br.com.codepath.api.model.enums.QuestionType;
import br.com.codepath.api.model.interfaces.IQuestion;
import br.com.codepath.api.repository.MatchingPairRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class MatchingPairStrategy implements IQuestion {
    
    @Autowired
    MatchingPairRepository matchingPairRepository;
    
    @Override
    public Map<String, String> getQuestionById(Long id) {

        List<MatchingPair> pairs = matchingPairRepository.findByQuestionId(id);
        StringBuilder allPairs = new StringBuilder("[");
        for (MatchingPair pair : pairs) {
            allPairs.append("[\"").append(pair.getLeftValue()).append("\",").append("\"").append(pair.getRightValue()).append("\"]").append(",");
        }
        allPairs = new StringBuilder(allPairs.substring(0, allPairs.length() - 1) + "]");


        return Map.of(
                "question", pairs.getFirst().getQuestion().getBody(),
                "type", QuestionType.MULTIPLE_CHOICE.name(),
                "options", allPairs.toString()
        );
    }

    @Override
    public Boolean verifyQuestionById(Long id, Answer answer) {
        List<MatchingPair> options = matchingPairRepository.findByQuestionId(id);
        for (MatchingPair pair : options) {
            if(answer.getLeftValue().equals(pair.getLeftValue()) && answer.getRightValue().equals(pair.getRightValue())) {
                return true;
            }
        }
        return false;
    }
}
