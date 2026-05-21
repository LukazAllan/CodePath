package br.com.codepath.api.strategies;

import java.util.List;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.codepath.api.dto.response.CourseEntiretyResponseDTO;
import br.com.codepath.api.interfaces.CourseInterface;
import br.com.codepath.api.model.Lesson;
import br.com.codepath.api.model.Section;
import br.com.codepath.api.repository.CourseRepository;
import br.com.codepath.api.repository.LessonRepository;
import br.com.codepath.api.repository.SectionRepository;

@NoArgsConstructor
public class CourseEntiretyStrategy implements CourseInterface {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    SectionRepository sectionRepository;

    @Override
    public CourseEntiretyResponseDTO create(Long id){
        CourseEntiretyResponseDTO dto = new CourseEntiretyResponseDTO();
        List<Section> sections = sectionRepository.findAllByCourseId(id);
        List<Lesson> lessons = lessonRepository.findAllBySectionCourseId(id);

        dto.setCourse(courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
        for (Section section : sections) {
            dto.addSection(section.toDTO());
        }
        for (Lesson lesson: lessons) {
            dto.addLesson(lesson.toDTO());
        }

        return dto;
    }

}
