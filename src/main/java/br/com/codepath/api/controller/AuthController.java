package br.com.codepath.api.controller;

import br.com.codepath.api.dto.request.NewUserRequestDTO;
import br.com.codepath.api.model.User;
import br.com.codepath.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody NewUserRequestDTO user) {
        authService.signUp(user);
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {

        String token = authService.login(
                body.get("email"),
                body.get("password")
        );

        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> me(@RequestBody Map<String, String> body){

        String hash = authService.me(
                body.get("hash")
        );

        return ResponseEntity.ok(Map.of("hash", hash));
    }
}