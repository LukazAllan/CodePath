package br.com.codepath.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.codepath.api.model.TrueFalse;

@Repository
public interface TrueFalseRepository extends JpaRepository<TrueFalse, Long> {
}
