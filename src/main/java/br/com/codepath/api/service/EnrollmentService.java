package br.com.codepath.api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.codepath.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.codepath.api.dto.response.CoursesByUserIdResponseDTO;
import br.com.codepath.api.dto.response.EnrollmentResponseDTO;
import br.com.codepath.api.model.Enrollment;
import br.com.codepath.api.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class EnrollmentService {
    @Autowired
    EnrollmentRepository enrollmentRepository;

    public void create(Enrollment enrollment){
        enrollment.setEnrolledAt(LocalDateTime.now());
        enrollmentRepository.save(enrollment);
    }

    public List<EnrollmentResponseDTO> listAll(){
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        ArrayList<EnrollmentResponseDTO> response = new ArrayList<>();
        for (Enrollment e: enrollments) {
            response.add(
                new EnrollmentResponseDTO(e)
            );
        }
        return response;
    }

    public EnrollmentResponseDTO listById(Long id){
        Enrollment e = enrollmentRepository.findById(id)
                        .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new EnrollmentResponseDTO(e);
    }

    public CoursesByUserIdResponseDTO listCourseByUserId(Long id){
        List<Enrollment> enrollments = enrollmentRepository.findAllByUserId(id);
        CoursesByUserIdResponseDTO response = new CoursesByUserIdResponseDTO();
        for (Enrollment enrollment : enrollments) {
            response.add(enrollment.getCourse());
        }
        return response;
    }

    public void updateById(Long id, Enrollment enrollmentedit){
        enrollmentedit.setId(id);
        enrollmentRepository.save(enrollmentedit);
    }

    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
