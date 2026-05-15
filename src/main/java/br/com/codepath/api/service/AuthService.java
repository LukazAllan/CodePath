package br.com.codepath.api.service;

import br.com.codepath.api.dto.request.NewUserRequestDTO;
import br.com.codepath.api.model.Session;
import br.com.codepath.api.model.User;
import br.com.codepath.api.repository.SessionRepository;
import br.com.codepath.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserService userService;

    private static final long TIMEOUT_MINUTES = 5;

    public void signUp(NewUserRequestDTO user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setXp(0);
        newUser.setHearts(10);
        userService.createUser(newUser);
    }

    public String login(String email, String password) {

        User user = userRepository
                .findByEmailAndPassword(email, password)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        String hash = UUID.randomUUID().toString();

        Session session = new Session();
        session.setUser(user);
        session.setHash(hash);
        session.setLastActivity(LocalDateTime.now());

        sessionRepository.save(session);

        return hash;
    }

    public User validateSession(String hash) {

        Session session = sessionRepository
                .findByHash(hash)
                .orElseThrow(() -> new RuntimeException("Sessão inválida"));

        if (session.getLastActivity()
                .plusMinutes(TIMEOUT_MINUTES)
                .isBefore(LocalDateTime.now())) {

            sessionRepository.delete(session);
            throw new RuntimeException("Sessão expirada");
        }

        session.setLastActivity(LocalDateTime.now());
        sessionRepository.save(session);

        return session.getUser();
    }

    public String me(String hash){
        Session mySession = sessionRepository
                .findByHash(hash)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        mySession.setLastActivity(LocalDateTime.now());
        sessionRepository.save(mySession);
        return mySession.getUser().getName();
    }
}