package br.com.codepath.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.codepath.api.dto.response.EnrollmentResponseDTO;
import br.com.codepath.api.dto.response.CoursesByUserIdResponseDTO;
import br.com.codepath.api.model.Enrollment;
import br.com.codepath.api.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Enrollment enrollment){
        enrollmentService.create(enrollment);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnrollmentResponseDTO> listAll(){
        return enrollmentService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnrollmentResponseDTO listById(@PathVariable Long id){
        return enrollmentService.listById(id);
    }
    
    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CoursesByUserIdResponseDTO listCourseByUserId(@PathVariable Long id){
        return enrollmentService.listCourseByUserId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateById(@PathVariable Long id, @RequestBody Enrollment enrollment){
        enrollmentService.updateById(id, enrollment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        enrollmentService.deleteById(id);
    }
}
