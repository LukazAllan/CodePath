package br.com.codepath.api.service;

import br.com.codepath.api.model.Question;
import br.com.codepath.api.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public void createQuest (Question question) {questionRepository.save(question);
    }
    public List<Question> findAllquest (){
        return questionRepository.findAll();
    }
    public Optional<Question> findbyIdquest (Long id){
        return questionRepository.findById(id);
    }
    public void updateQuest(Long id, Question updatedQuestion) {
        Optional<Question> question = questionRepository.findById(id);

        question.get().setBody(updatedQuestion.getBody());
        question.get().setType(updatedQuestion.getType());
        question.get().setLesson(updatedQuestion.getLesson());

        questionRepository.save(updatedQuestion);
    }
    public void deleteQuest(Long id) {
        questionRepository.deleteById(id);
    }
}