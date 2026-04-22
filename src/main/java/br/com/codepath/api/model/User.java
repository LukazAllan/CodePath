package br.com.codepath.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "usuarios")
@Entity
public class User extends UserAbstract {

    @OneToMany(mappedBy = "user")
    private Collection<LessonProgress> lessonProgress;

    public Collection<LessonProgress> getLessonProgress() {
        return lessonProgress;
    }

    public void setLessonProgress(Collection<LessonProgress> lessonProgress) {
        this.lessonProgress = lessonProgress;
    }
}
