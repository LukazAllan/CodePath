package br.com.codepath.api.model;

import br.com.codepath.api.model.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer xp = 0;

    @Column(nullable = false)
    private Integer hearts = 10;

    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.USER;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<LessonProgress> lessonProgress;
}
