package br.com.codepath.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "section")
@Data
public class Section {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    private String title;
    private String subtitle;
    private String color;
    private Char icon;
    private int order;
}