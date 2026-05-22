package br.com.codepath.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codepath.api.dto.response.CourseEntiretyResponseDTO;
import br.com.codepath.api.model.Course;
import br.com.codepath.api.repository.CourseRepository;
import br.com.codepath.api.strategies.CourseEntiretyStrategy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    

    public void create(Course course){
        courseRepository.save(course);
    }
    public List<Course> listAll(){
        return courseRepository.findAll();
    }
    public CourseEntiretyResponseDTO listById(Long id){
        return new CourseEntiretyStrategy().create(id);
    }
    public void updateById(Long id, Course courseEdit){
        courseEdit.setId(id);
        courseRepository.save(courseEdit);
    }
    public void deleteById(Long id){
        courseRepository.deleteById(id);
    }
}
