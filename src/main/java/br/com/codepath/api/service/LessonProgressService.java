package br.com.codepath.api.service;

import br.com.codepath.api.dto.response.LessonProgressResponseDTO;
import br.com.codepath.api.model.LessonProgress;
import br.com.codepath.api.repository.LessonProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonProgressService {

    @Autowired
    LessonProgressRepository lessonProgressRepository;

    public void create(LessonProgress lessonProgress) {
        lessonProgressRepository.save(lessonProgress);
    }

    public List<LessonProgressResponseDTO> listAll() {
        return lessonProgressRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public LessonProgressResponseDTO toDTO(LessonProgress progress) {
        return new LessonProgressResponseDTO(
                progress.getId(),
                progress.getUser().getId(),
                progress.getLesson().getId(),
                progress.getStatus(),
                progress.getCompleted(),
                progress.getCompletedAt()
        );
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
