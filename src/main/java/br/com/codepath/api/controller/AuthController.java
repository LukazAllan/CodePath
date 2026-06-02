package br.com.codepath.api.controller;

import br.com.codepath.api.dto.request.LoginRequestDTO;
import br.com.codepath.api.dto.request.NewUserRequestDTO;
import br.com.codepath.api.dto.request.TokenRequestDTO;
import br.com.codepath.api.dto.response.UserResponseDTO;
import br.com.codepath.api.dto.response.TokenResponseDTO;
import br.com.codepath.api.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponseDTO signUp(@RequestBody NewUserRequestDTO user,
                                   HttpServletRequest req) {
        return authService.signUp(user, req.getRemoteAddr());
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponseDTO login(@RequestBody LoginRequestDTO request,
                                  HttpServletRequest req) {
        return authService.login(
                request.getEmail(),
                request.getPassword(),
                req.getRemoteAddr()
        );
    }

    @PostMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO me(@RequestBody TokenRequestDTO request,
                              HttpServletRequest req) {
        System.out.println(req.getRemoteAddr());
        return authService.me(
                request.getToken()
        );
    }
}