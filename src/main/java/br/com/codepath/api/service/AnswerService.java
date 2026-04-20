package br.com.codepath.api.service;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public List<Answer> listAllAnswers() {
        return answerRepository.findAll();
    }

    public Optional<Answer> listByIdAnswer(Long id) {
        return answerRepository.findById(id);
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

    public void updateAnswer(Long id, Answer answerEdit) {
        answerEdit.setId(id);
        answerRepository.save(answerEdit);
    }
}
