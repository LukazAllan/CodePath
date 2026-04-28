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
    public void createSuggestion(@RequestBody Suggestion suggestion) {
         suggestionService.createSuggestion(suggestion);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Suggestion> ListAllSuggestions() {
        return suggestionService.ListAllSuggestions();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Suggestion> findByIdSuggestion(@PathVariable Long id) {
        return suggestionService.findByIdSuggestion(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSuggestion(@PathVariable Long id) {
        suggestionService.deleteSuggestionById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSuggestion(@PathVariable Long id, @RequestBody Suggestion suggestionEdit) {
        suggestionService.UpdateSuggestion(id, suggestionEdit);
    }
}
