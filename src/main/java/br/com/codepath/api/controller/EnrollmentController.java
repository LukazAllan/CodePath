package br.com.codepath.api.controller;

import br.com.codepath.api.model.Enrollment;
import br.com.codepath.api.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(Enrollment enrollment){
        enrollmentService.create(enrollment);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Enrollment> listAll(){
        return enrollmentService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Enrollment> listById(@PathVariable Long id){
        return enrollmentService.listById(id);
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
