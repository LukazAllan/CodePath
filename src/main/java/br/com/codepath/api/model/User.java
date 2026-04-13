package br.com.codepath.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "user")
@Entity
public class User extends UserAbstract {

    public User(Long id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public User(){
        super();
    }
}
