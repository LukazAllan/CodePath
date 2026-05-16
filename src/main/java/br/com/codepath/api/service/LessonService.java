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

    public void create(Lesson lesson){
        lessonRepository.save(lesson);
    }
    public List<Lesson> listAll(){
        return lessonRepository.findAll();
    }
    public Optional<Lesson> listById(Long id){
        return lessonRepository.findById(id);
    }
    public void deleteById(Long id){
        lessonRepository.deleteById(id);
    }
    public void updateById(Long id, Lesson lessonEdit){
        lessonEdit.setId(id);
        lessonRepository.save(lessonEdit);
    }
}
