package br.com.codepath.api.service;

import br.com.codepath.api.model.Enrollment;
import br.com.codepath.api.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class EnrollmentService {
    @Autowired
    EnrollmentRepository enrollmentRepository;

    public void createEnrollment (Enrollment enrollment){
        enrollmentRepository.save(enrollment);
    }
    public List<Enrollment> listAllenrollment(){
        return enrollmentRepository.findAll();
    }
    public Optional<Enrollment> listByidEnrollment(Long id){
        return enrollmentRepository.findById(id);
    }
    public void updateEnrollment (Long id,Enrollment enrollmentedit){
        enrollmentedit.setId(id);
        enrollmentRepository.save(enrollmentedit);
    }
    public void deleteEnrollment (Long id) {
        enrollmentRepository.deleteById(id);
    }
}
