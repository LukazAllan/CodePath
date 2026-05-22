package br.com.codepath.api.strategies;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.codepath.api.dto.response.CourseEntiretyResponseDTO;
import br.com.codepath.api.interfaces.CourseInterface;
import br.com.codepath.api.repository.CourseRepository;
import br.com.codepath.api.repository.LessonRepository;
import br.com.codepath.api.repository.SectionRepository;

@NoArgsConstructor
@Component
public class CourseEntiretyStrategy implements CourseInterface {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    SectionRepository sectionRepository;

    @Override
    public CourseEntiretyResponseDTO create(Long id){
        return new CourseEntiretyResponseDTO(
                courseRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),
                sectionRepository.findAllByCourseId(id),
                lessonRepository.findAllBySectionCourseId(id)
        );
    }

}
