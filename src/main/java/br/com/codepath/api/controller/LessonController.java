package br.com.codepath.api.controller;

import br.com.codepath.api.model.Lesson;
import br.com.codepath.api.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    LessonService lessonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createLesson(@RequestBody Lesson lesson){lessonService.createLesson(lesson);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Lesson> listAlllesson(){return lessonService.listAlllesson();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Lesson> listByidLesson(@PathVariable Long id){return lessonService.listByidLesson(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLesson(@PathVariable Long id){lessonService.deleteLesson(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updtadeLesson(@PathVariable Long id,@RequestBody Lesson lessonEdit){lessonService.updateLesson(id,lessonEdit);}

}
