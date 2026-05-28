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

    public void create(Question question) {
        questionRepository.save(question);
    }
    public List<Question> listAll(){
        return questionRepository.findAll();
    }
    public Optional<Question> listById(Long id){
        return questionRepository.findById(id);
    }
    public void updateById(Long id, Question questionEdit) {
//      Optional<Question> question = questionRepository.findById(id);
//      question.get().setBody(updatedQuestion.getBody());
//      question.get().setType(updatedQuestion.getType());
//      question.get().setLesson(updatedQuestion.getLesson());
        questionEdit.setId(id);
        questionRepository.save(questionEdit);
    }
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}