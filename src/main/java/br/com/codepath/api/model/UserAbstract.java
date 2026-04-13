package br.com.codepath.api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class UserAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;
    protected String email;
    protected String password;

}
