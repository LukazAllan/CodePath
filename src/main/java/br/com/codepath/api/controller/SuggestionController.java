package br.com.codepath.api.controller;

import br.com.codepath.api.model.Suggestion;
import br.com.codepath.api.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
    @Autowired
    SuggestionService suggestionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Suggestion suggestion) {
         suggestionService.create(suggestion);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Suggestion> ListAll() {return suggestionService.listAll();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Suggestion> listById(@PathVariable Long id) {return suggestionService.listById(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        suggestionService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateById(@PathVariable Long id, @RequestBody Suggestion suggestionEdit) {suggestionService.updateById(id, suggestionEdit);}
}
