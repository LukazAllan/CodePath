package br.com.codepath.api.model.interfaces;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.model.Question;

import java.util.Map;

public interface IQuestion {

    Map<String, String> getQuestion(Long id);

    Boolean verifyQuestion(Long id, Answer answer);
}