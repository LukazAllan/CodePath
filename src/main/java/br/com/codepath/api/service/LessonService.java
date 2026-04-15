package br.com.codepath.api.service;

import br.com.codepath.api.model.Lesson;
import br.com.codepath.api.repository.LessonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    public void createLesson(Lesson lesson){
        lessonRepository.save(lesson);
    }
    public List<Lesson> listAlllesson(){
        return lessonRepository.findAll();
    }
    public Optional<Lesson> listByidLesson(Long id){
        return lessonRepository.findById(id);
    }
    public void deleteLesson(Long id){
        lessonRepository.deleteById(id);
    }
    public void updateLesson(Long id, Lesson lessonEdit){
        lessonEdit.setId(id);
        lessonRepository.save(lessonEdit);
    }
}
