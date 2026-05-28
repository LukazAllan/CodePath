package br.com.codepath.api.controller;

import br.com.codepath.api.model.Session;
import br.com.codepath.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Session> listAll() {
        return sessionService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Session listById(@PathVariable Long id) {
        return sessionService.listById(id);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateById(
//            @RequestParam Map<String, Integer> params){
//        if (params.containsKey("revoke")) {
//            sessionService.revokeById(Long.valueOf(params.get("revoke")));
//        } else if (params.containsKey("refresh")) {
//            sessionService.refreshById(Long.valueOf(params.get("refresh")));
//        }
//        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
//    }

    @PostMapping("/revoke/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void revoke(@PathVariable Long id) {
        sessionService.revokeById(id);
    }

    @PostMapping("/refresh/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void refresh(@PathVariable Long id) {
        sessionService.refreshById(id);
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id){
        sessionService.deleteById(id);
    }
}
