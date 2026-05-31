package br.com.codepath.api.dto.aprender;

import java.time.LocalDateTime;
import java.util.List;

import br.com.codepath.api.model.enums.LessonProgressStatus;
import br.com.codepath.api.model.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AprenderResponseDTO {
    private MockUser user;
    private MockCourse course;
}
