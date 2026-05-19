package br.com.codepath.api.service;

import br.com.codepath.api.dto.request.CreateLessonRequestDTO;
import br.com.codepath.api.model.Lesson;
import br.com.codepath.api.repository.LessonRepository;
import br.com.codepath.api.repository.SectionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LessonService {
    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    LessonRepository lessonRepository;

//    public void create(CreateLessonRequestDTO request) {
    public void create(Lesson lesson) {
//        Lesson lesson = new Lesson();
//        lesson.setName(request.getName());
//        lesson.setContent(request.getContent());
//        lesson.setOrdem(request.getOrdem());
//        lesson.setActive(request.getActive());
//        lesson.setSection(sectionRepository.findById(request.getSectionId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
//        );
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
