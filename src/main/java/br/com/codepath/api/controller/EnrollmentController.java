package br.com.codepath.api.controller;

import br.com.codepath.api.model.Enrollment;
import br.com.codepath.api.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

}
