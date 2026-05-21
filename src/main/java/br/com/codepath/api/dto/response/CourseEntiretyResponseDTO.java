package br.com.codepath.api.dto.response;

import java.util.List;

import br.com.codepath.api.dto.LessonDTO;
import br.com.codepath.api.dto.SectionDTO;
import br.com.codepath.api.model.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CourseEntiretyResponseDTO {
    private Course course;
    private List<SectionDTO> sections;
    private List<LessonDTO> lessons;

    public void addSection(SectionDTO section){
        sections.add(section);
    }

    public void addLesson(LessonDTO lesson){
        lessons.add(lesson);
    }
}
