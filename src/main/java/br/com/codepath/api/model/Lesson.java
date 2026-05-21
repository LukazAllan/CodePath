package br.com.codepath.api.model;

import br.com.codepath.api.dto.LessonDTO;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public LessonDTO toDTO() {
        return new LessonDTO(
                this.name,
                this.content,
                this.ordem,
                this.active
        );
    }
}
