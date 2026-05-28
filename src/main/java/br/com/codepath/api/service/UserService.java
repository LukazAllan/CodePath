package br.com.codepath.api.service;

import br.com.codepath.api.model.User;
import br.com.codepath.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void create(User user) {
        if (user.getName() == null || user.getName().isBlank() ||
                user.getPassword() == null || user.getPassword().isBlank() ||
                user.getEmail() == null || user.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getXp() == null){
            user.setXp(0);
        }
        if (user.getHearts() == null){
            user.setHearts(10);
        }
        userRepository.save(user);
    }
    public List<User> listAll(){return userRepository.findAll();}
    public Optional<User> listById(Long id){return userRepository.findById(id);}
    public void deleteById(Long id){userRepository.deleteById(id);}
    public void updateById(Long id,User userEdit){userEdit.setId(id); userRepository.save(userEdit);}
}
