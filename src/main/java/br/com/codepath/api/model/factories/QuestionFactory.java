package br.com.codepath.api.model.factories;

import  br.com.codepath.api.model.interfaces.IQuestion;
import  br.com.codepath.api.model.strategies.ShortTextStrategy;
import  br.com.codepath.api.model.strategies.TrueFalseStrategy;
import  br.com.codepath.api.model.strategies.MatchingPairStrategy;
import  br.com.codepath.api.model.strategies.MultipleChoiceStrategy;
import  br.com.codepath.api.model.enums.QuestionType;


public class QuestionFactory {
    QuestionFactory() {}
    
    public IQuestion create(QuestionType questionType){
        if (questionType == QuestionType.MATCHING){
            return new MatchingPairStrategy();
        }
        if (questionType == QuestionType.MULTIPLE_CHOICE){
            return new MultipleChoiceStrategy();
        }
        if (questionType == QuestionType.TRUE_FALSE){
            return new TrueFalseStrategy();
        }
        if (questionType == QuestionType.SHORT_TEXT){
            return new ShortTextStrategy();
        }
        throw new IllegalArgumentException("Invalid Question Type");
    }
}