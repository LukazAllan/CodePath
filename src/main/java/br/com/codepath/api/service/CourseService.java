package br.com.codepath.api.service;

import br.com.codepath.api.model.Course;
import br.com.codepath.api.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public void createCourse (Course course){
        courseRepository.save(course);
    }
    public List<Course> listAllcourse (){
        return courseRepository.findAll();
    }
    public Optional<Course> listByidCourse(Long id){
        return courseRepository.findById(id);
    }
    public void updateCourse (Long id, Course courseEdit){
        courseEdit.setId(id);
        courseRepository.save(courseEdit);
    }
    public void deleteCourse (Long id){
        courseRepository.deleteById(id);
    }
}
