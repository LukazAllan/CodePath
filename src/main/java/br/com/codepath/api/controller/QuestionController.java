package br.com.codepath.api.controller;

import br.com.codepath.api.model.Question;
import br.com.codepath.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createquest(@RequestBody Question question){
        service.createQuest(question);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Question> findAllquest() {
        return service.findAllquest();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Question> findById(@PathVariable Long id) {
        return service.findbyIdquest(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatequest(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        service.updateQuest(id, updatedQuestion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletequest(@PathVariable Long id) {
        service.deleteQuest(id);
    }
}
