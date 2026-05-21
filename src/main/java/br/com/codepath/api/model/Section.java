package br.com.codepath.api.model;

import br.com.codepath.api.dto.SectionDTO;
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
    private Character icon;
    private Integer ordem;

    public SectionDTO toDTO(){
        return new SectionDTO(
                this.title,
                this.subtitle,
                this.color,
                this.icon,
                this.ordem
        );
    }
}