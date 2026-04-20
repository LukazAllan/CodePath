package br.com.codepath.api.controller;

import br.com.codepath.api.model.Course;
import br.com.codepath.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Courses")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse (@RequestBody Course course) {service.createCourse(course);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Course> listAllcourse(){return service.listAllcourse();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Course> listByidCourse(@PathVariable Long id){return service.listByidCourse(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@PathVariable Long id,@RequestBody Course courseEdit){service.updateCourse(id,courseEdit);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id){service.deleteCourse(id);}
}
