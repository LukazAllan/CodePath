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

    public void create(Answer answer) {
        answerRepository.save(answer);
    }

    public List<Answer> listAll() {
        return answerRepository.findAll();
    }

    public Optional<Answer> listById(Long id) {
        return answerRepository.findById(id);
    }

    public void deleteById(Long id) {
        answerRepository.deleteById(id);
    }

    public void updateById(Long id, Answer answerEdit) {
        answerEdit.setId(id);
        answerRepository.save(answerEdit);
    }
}
