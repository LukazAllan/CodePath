package br.com.codepath.api.service;

import br.com.codepath.api.model.Section;
import br.com.codepath.api.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    SectionRepository sectionRepository;

    public void create(Section section) {
        sectionRepository.save(section);
    }
    public List<Section> listAll(){
        return sectionRepository.findAll();
    }
    public Optional<Section> listById(Long id){
        return sectionRepository.findById(id);
    }
    public void deleteById(Long id){
        sectionRepository.deleteById(id);
    }
    public void updateById(Long id, Section lessonEdit){
        lessonEdit.setId(id);
        sectionRepository.save(lessonEdit);
    }
}
