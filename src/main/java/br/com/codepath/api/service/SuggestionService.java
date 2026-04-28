package br.com.codepath.api.service;

import br.com.codepath.api.model.Suggestion;
import br.com.codepath.api.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuggestionService {
    @Autowired
    SuggestionRepository suggestionRepository;

    public void createSuggestion(Suggestion suggestion) {
        suggestionRepository.save(suggestion);
    }

    public List<Suggestion> ListAllSuggestions() {
        return suggestionRepository.findAll();
    }

    public Optional<Suggestion> findByIdSuggestion(Long id) {
        return suggestionRepository.findById(id);
    }

    public void deleteSuggestionById(Long id) {
        suggestionRepository.deleteById(id);
    }

    public void UpdateSuggestion(Long id, Suggestion suggestionEdit) {
        suggestionEdit.setId(id);
        suggestionRepository.save(suggestionEdit);
    }
}
