package br.com.codepath.api.model.interfaces;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.model.Question;

import java.util.Map;

public interface IQuestion {

    Map<String, String> getQuestionById(Long id);

    Boolean verifyQuestionById(Long id, Answer answer);
}