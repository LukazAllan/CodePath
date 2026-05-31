package br.com.codepath.api.repository;

import br.com.codepath.api.model.LessonProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {
    List<LessonProgress> findAllByUserId(Long userId);
}
