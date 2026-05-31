package br.com.codepath.api.controller;

import br.com.codepath.api.dto.SectionDTO;
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
    public void create(@RequestBody Section section) {
        sectionService.create(section);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Section> listAll(){
        return sectionService.listAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SectionDTO listById(@PathVariable Long id){
        return sectionService.listById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        sectionService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Section section){
        sectionService.updateById(id, section);
    }
}
