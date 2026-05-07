package br.com.codepath.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "usuarios")
@Entity
public class User extends UserAbstract {

    private int xp;
    private int hearts;

    @OneToMany(mappedBy = "user")
    private Collection<LessonProgress> lessonProgress;
}
