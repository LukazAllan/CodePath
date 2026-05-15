package br.com.codepath.api.controller;

import br.com.codepath.api.model.User;
import br.com.codepath.api.service.UserService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUser(){return userService.listAllUser();}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> findUserById(@PathVariable Long id){return userService.listByIdUser(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id){userService.deleteUserById(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Long id, @RequestBody User userEdit){userService.updateUser(id,userEdit);}
}
