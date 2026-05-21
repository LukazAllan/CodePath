package br.com.codepath.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codepath.api.model.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    public List<Section> findAllByCourseId(Long id);
}
