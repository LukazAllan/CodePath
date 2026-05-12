package br.com.codepath.api.controller;

import br.com.codepath.api.model.Section;
import br.com.codepath.api.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    SectionService sectionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSection(@RequestBody Section section){sectionService.createSection(section);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Section> findAllSection(){return sectionService.findAllSection();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Section> findByIdSection(@PathVariable Long id){return  sectionService.findByIdSection(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSection(@PathVariable Long id, @RequestBody Section sectionEdit){sectionService.updateSection(id, sectionEdit);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSection(@PathVariable Long id){sectionService.deleteSection(id);}
}
