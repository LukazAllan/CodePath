package br.com.codepath.api.model.interfaces;

import java.util.Map;

public interface IQuestion {

    public Map<String, String> getQuestion();

    public Boolean verifyQuestion();
}
