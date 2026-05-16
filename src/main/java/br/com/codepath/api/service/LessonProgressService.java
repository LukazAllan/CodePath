package br.com.codepath.api.service;

import br.com.codepath.api.model.LessonProgress;
import br.com.codepath.api.repository.LessonProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LessonProgressService {

    @Autowired
    LessonProgressRepository lessonProgressRepository;

    public void create(LessonProgress lessonProgress) {
        lessonProgressRepository.save(lessonProgress);
    }

    public List<LessonProgress> listAll() {
        return lessonProgressRepository.findAll();
    }

    public Optional<LessonProgress> listById(Long id) {
        return lessonProgressRepository.findById(id);
    }

    public void deleteById(Long id) {
        lessonProgressRepository.deleteById(id);
    }

    public void updateById(Long id, LessonProgress lessonProgressEdit) {
        lessonProgressEdit.setId(id);
        lessonProgressRepository.save(lessonProgressEdit);
    }
}
