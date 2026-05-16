package br.com.codepath.api.service;

import br.com.codepath.api.model.Session;
import br.com.codepath.api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> listAll() {
        return sessionRepository.findAll();
    }

    public Session listById(Long id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void revokeById(Long id){
        Session thisSession = sessionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        thisSession.setLastActivity(
                thisSession.getLastActivity().minusDays(1)
        );
    }

    public void refreshById(Long id){
        Session thisSession = sessionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        thisSession.setLastActivity(LocalDateTime.now());
    }

    public void deleteById(Long id){
        sessionRepository.deleteById(id);
    }
}
