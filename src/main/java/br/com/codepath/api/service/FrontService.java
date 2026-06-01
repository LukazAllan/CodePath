package br.com.codepath.api.service;
import br.com.codepath.api.dto.aprender.*;
import br.com.codepath.api.dto.response.*;
import br.com.codepath.api.model.*;
import br.com.codepath.api.repository.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class FrontService {
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    LessonProgressRepository lpRepository;

    public AprenderResponseDTO printAllUserInfo(Long userId, Integer courseId) {

        Enrollment enrollment = enrollmentRepository.findByUserIdAndCourseId(userId, courseId.longValue())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Usuário não possui cursos matriculados"));

        User user = enrollment.getUser();

        MockUser mockUser = new MockUser(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getXp(),
                user.getHearts(),
                user.getRole(),
                user.getCreatedAt()
        );

        // Exemplo: retorna apenas o primeiro curso matriculado
        Course course = enrollment.getCourse()  ;

        List<MockSection> mockSections = new ArrayList<>();

        List<Section> sections = sectionRepository.findAllByCourseId(course.getId());

        for (Section section : sections) {
            List<MockLesson> mockLessons = new ArrayList<>();
            List<Lesson> lessons = lessonRepository.findAllBySectionCourseId(section.getId());

            for (Lesson lesson : lessons) {
                LessonProgress lp = lpRepository.findByUserIdAndLessonId(userId, lesson.getId());

                MockProgress progress = null;
                if (lp != null) {
                    progress = new MockProgress(
                            lp.getStatus(),
                            lp.getStars(),
                            lp.getCompleted(),
                            lp.getCompletedAt()
                    );
                }
                mockLessons.add(
                        new MockLesson(
                                lesson.getName(),
                                lesson.getContent(),
                                progress
                        )
                );
            }
            mockSections.add(
                    new MockSection(
                            section.getTitle(),
                            section.getSubtitle(),
                            section.getColor(),
                            section.getIcon().toString(),
                            section.getOrdem(),
                            mockLessons
                    )
            );
        }

        MockCourse mockCourse = new MockCourse(course.getName(), mockSections);

        return new AprenderResponseDTO(mockUser, mockCourse);
    }
}