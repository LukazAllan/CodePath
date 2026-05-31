package br.com.codepath.api.dto.response;

import java.util.ArrayList;

import br.com.codepath.api.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CoursesByUserIdResponseDTO{
    private ArrayList<SimilarCourse> courses = new ArrayList<>();

    public void add(Course c){
        courses.add(
            new SimilarCourse(
                c.getId(),
                c.getName()
            )
        );
    }
}

@AllArgsConstructor
@Data
class SimilarCourse {
    private Long courseId;
    private String courseName;
}