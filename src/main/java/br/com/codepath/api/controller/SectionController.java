package br.com.codepath.api.controller;

import br.com.codepath.api.model.Section;
import br.com.codepath.api.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    SectionService sectionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(Section section) {
        sectionService.create(section);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Section> listAll(){
        return sectionService.listAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Section> listById(@PathVariable Long id){
        return sectionService.listById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id){
        sectionService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(Long id, Section sectionEdit){
        sectionService.update(id, sectionEdit);
    }
}
