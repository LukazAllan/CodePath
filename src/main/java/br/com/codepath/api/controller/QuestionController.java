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
    public void create(@RequestBody Question question){
        service.create(question);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Question> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Question> findById(@PathVariable Long id) {
        return service.listById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        service.updateById(id, updatedQuestion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
