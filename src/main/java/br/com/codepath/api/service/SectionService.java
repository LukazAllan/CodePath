package br.com.codepath.api.service;

import br.com.codepath.api.model.Section;
import br.com.codepath.api.repository.SectionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class SectionService {

    @Autowired
    SectionRepository sectionRepository;

    public void createSection(Section section){
        sectionRepository.save(section);
    }
    public List<Section> findAllSection(){
        return sectionRepository.findAll();
    }
    public Optional<Section> findByIdSection(Long id){
        return sectionRepository.findById(id);
    }
    public void updateSection(Long id, Section sectionEdit){
        sectionEdit.setId(id);
        sectionRepository.save(sectionEdit);
    }
    public void deleteSection(Long id){
        sectionRepository.deleteById(id);
    }
}