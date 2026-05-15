package br.com.codepath.api.service;

import br.com.codepath.api.model.User;
import br.com.codepath.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }
    public List<User> listAllUser(){return userRepository.findAll();}
    public Optional<User> listByIdUser(Long id){return userRepository.findById(id);}
    public void deleteUserById(Long id){userRepository.deleteById(id);}
    public void updateUser(Long id,User userEdit){userEdit.setId(id); userRepository.save(userEdit);}
}
