package br.com.codepath.api.repository;

import br.com.codepath.api.model.Course;
import br.com.codepath.api.model.LessonProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {
}
