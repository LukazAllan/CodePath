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
    public void create(@RequestBody Lesson lesson) {
        lessonService.create(lesson);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Lesson> listAll(){return lessonService.listAll();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Lesson> listById(@PathVariable Long id){return lessonService.listById(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){lessonService.deleteById(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Lesson lessonedit){lessonService.updateById(id,lessonedit);}
}
