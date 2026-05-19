package br.com.codepath.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson")
@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    private Integer ordem;
    private Boolean active;
}
