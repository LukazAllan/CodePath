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
    public void createAnswer(@RequestBody Answer answer) {answerService.createAnswer(answer);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Answer> listAllAnswers() {return answerService.listAllAnswers();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Answer> listAnswerById(@PathVariable Long id) {return answerService.listByIdAnswer(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnswerById(@PathVariable Long id) {answerService.deleteAnswer(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAnswerById(@PathVariable Long id, @RequestBody Answer answerEdit) {answerService.updateAnswer(id, answerEdit);}
}
