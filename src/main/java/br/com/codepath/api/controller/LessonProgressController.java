package br.com.codepath.api.controller;

import br.com.codepath.api.model.LessonProgress;
import br.com.codepath.api.service.LessonProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lesson-progress")
public class LessonProgressController {
    @Autowired
    LessonProgressService lessonProgressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody LessonProgress lessonProgress) {
        lessonProgressService.create(lessonProgress);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LessonProgress> listAll() {
        return lessonProgressService.listAll();
    }

    @GetMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LessonProgress> listAllByUserId(@PathVariable Long userId){return lessonProgressService.listAllByUserId(userId);}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<LessonProgress> listById(@PathVariable Long id) {
        return lessonProgressService.listById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        lessonProgressService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateById(@PathVariable Long id, @RequestBody LessonProgress lessonProgressEdit) {
        lessonProgressService.updateById(id, lessonProgressEdit);
    }
}
