package br.com.codepath.api.dto.response;

import br.com.codepath.api.model.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author allan
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentResponseDTO {
    private Long userId;
    private String userName;
    private Long courseId;
    private String courseName;

    public EnrollmentResponseDTO(Enrollment e){
        this(
            e.getUser().getId(), 
            e.getUser().getName(), 
            e.getCourse().getId(), 
            e.getCourse().getName()
        );
    }
}
