package br.com.codepath.api.dto.response;

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

@AllArgsConstructor
@Data
class MockUser{
    private String name;
    private String email;
    private String password;
    private Integer xp;
    private Integer hearts;
    private RoleEnum role;
    private LocalDateTime createdAt;
}

@AllArgsConstructor
@Data
class MockProgress{
    private LessonProgressStatus status;
    private Short stars;
    private Boolean completed;
    private LocalDateTime completedAt;
}

@AllArgsConstructor
@Data
class MockLesson{
    private String name;
    private String content;
    private MockProgress progress;
}

@AllArgsConstructor
@Data
class MockSection{
    private String title;
    private String subtitle;
    private String color;
    private String icon;
    private Integer ordem;
    private List<MockLesson> lessons;
}

@AllArgsConstructor
@Data
class MockCourse{
    private String courseName;
    private List<MockSection> sections;
}
