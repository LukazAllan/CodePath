package br.com.codepath.api.dto.response;

import java.util.List;

import br.com.codepath.api.dto.LessonDTO;
import br.com.codepath.api.dto.SectionDTO;
import br.com.codepath.api.model.Course;
import br.com.codepath.api.model.Lesson;
import br.com.codepath.api.model.Section;
import lombok.Data;

@Data
public class CourseEntiretyResponseDTO {
    private Course course;
    private List<SectionDTO> sections;
    private List<LessonDTO> lessons;

    public CourseEntiretyResponseDTO(Course course, List<Section> sections, List<Lesson> lessons) {
        this.course = course;
        for (Section section : sections) {
            this.sections.add(section.toDTO());
        }
        for (Lesson lesson : lessons) {
            this.lessons.add(lesson.toDTO());
        }
    }
}
