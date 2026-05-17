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

    public void create(Suggestion suggestion) {
        suggestionRepository.save(suggestion);
    }
    public List<Suggestion> listAll() {
        return suggestionRepository.findAll();
    }
    public Optional<Suggestion> listById(Long id) {
        return suggestionRepository.findById(id);
    }
    public void deleteById(Long id) {
        suggestionRepository.deleteById(id);
    }
    public void updateById(Long id, Suggestion suggestionEdit) {suggestionEdit.setId(id);suggestionRepository.save(suggestionEdit);}
}
