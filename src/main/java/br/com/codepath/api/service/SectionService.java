package br.com.codepath.api.service;

import br.com.codepath.api.dto.SectionDTO;
import br.com.codepath.api.dto.request.SectionRequestDTO;
import br.com.codepath.api.model.Section;
import br.com.codepath.api.repository.CourseRepository;
import br.com.codepath.api.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SectionRepository sectionRepository;

//    public void create(SectionRequestDTO request) {
    public void create(Section section) {
//        Section section = new Section();
//        section.setTitle(request.getTitle());
//        section.setSubtitle(request.getSubtitle());
//        section.setColor(request.getColor());
//        section.setIcon(request.getIcon());
//        section.setOrdem(request.getOrdem());
//        section.setCourse(courseRepository.findById(request.getCourseId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        sectionRepository.save(section);
    }
    public List<Section> listAll(){
        return sectionRepository.findAll();
    }
    public SectionDTO listById(Long id){
        return sectionRepository.findById(id)
        .map(Section::toDTO)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public void deleteById(Long id){
        sectionRepository.deleteById(id);
    }
//    public void updateById(Long id, SectionRequestDTO request){
    public void updateById(Long id, Section section){
//        Section section = new Section();
//        section.setTitle(request.getTitle());
//        section.setSubtitle(request.getSubtitle());
//        section.setColor(request.getColor());
//        section.setIcon(request.getIcon());
//        section.setOrdem(request.getOrdem());
//        section.setCourse(courseRepository.findById(request.getCourseId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        section.setId(id);
        sectionRepository.save(section);
    }
}
