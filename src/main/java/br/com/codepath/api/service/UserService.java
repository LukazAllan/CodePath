package br.com.codepath.api.service;

import br.com.codepath.api.model.User;
import br.com.codepath.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public Optional<User> findUserById(Long id) { return userRepository.findById(id);}
}
