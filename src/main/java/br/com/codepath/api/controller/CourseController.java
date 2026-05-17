package br.com.codepath.api.controller;

import br.com.codepath.api.model.Course;
import br.com.codepath.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Course course) {service.create(course);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Course> listAll(){return service.listAll();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Course> listById(@PathVariable Long id){return service.listById(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id,@RequestBody Course courseEdit){service.updateById(id,courseEdit);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){service.deleteById(id);}
}
