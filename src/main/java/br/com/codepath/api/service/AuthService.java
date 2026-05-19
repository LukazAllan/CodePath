package br.com.codepath.api.service;

import br.com.codepath.api.dto.request.NewUserRequestDTO;
import br.com.codepath.api.dto.response.MeResponseDTO;
import br.com.codepath.api.dto.response.TokenResponseDTO;
import br.com.codepath.api.model.Session;
import br.com.codepath.api.model.User;
import br.com.codepath.api.repository.SessionRepository;
import br.com.codepath.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.sqlite.SQLiteException;

import java.time.LocalDateTime;
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

    public TokenResponseDTO login(String email, String password) {

        User user = userRepository
                .findByEmailAndPassword(email, password)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Session session = sessionRepository.findByUserId(user.getId())
                .orElse(new Session());
        if (session.getToken() == null) {
            String token = UUID.randomUUID().toString();
            session.setUser(user);
            session.setToken(token);
            session.setLastActivity(LocalDateTime.now());
            sessionRepository.save(session);
        }

        return new TokenResponseDTO(session.getToken());
    }


    public TokenResponseDTO signUp(NewUserRequestDTO user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setXp(0);
        newUser.setHearts(10);
        userService.create(newUser);
        return this.login(user.getEmail(), user.getPassword());
    }

    public User validateSession(String token) {

        Session session = sessionRepository
                .findByToken(token)
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

    public MeResponseDTO me(String token){
        Session mySession = sessionRepository
                .findByToken(token)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        mySession.setLastActivity(LocalDateTime.now());
        MeResponseDTO me = new MeResponseDTO(
                mySession.getUser().getName(),
                mySession.getUser().getEmail(),
                mySession.getToken(),
                mySession.getLastActivity()
        );
        sessionRepository.save(mySession);
        return me;
    }
}