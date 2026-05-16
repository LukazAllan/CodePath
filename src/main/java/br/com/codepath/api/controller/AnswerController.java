package br.com.codepath.api.controller;

import br.com.codepath.api.model.Answer;
import br.com.codepath.api.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Answer answer) {answerService.create(answer);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Answer> listAll() {return answerService.listAll();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Answer> listById(@PathVariable Long id) {return answerService.listById(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {answerService.deleteById(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateById(@PathVariable Long id, @RequestBody Answer answerEdit) {answerService.updateById(id, answerEdit);}
}
