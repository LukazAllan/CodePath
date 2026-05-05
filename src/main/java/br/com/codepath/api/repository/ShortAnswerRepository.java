package br.com.codepath.api.repository;

import br.com.codepath.api.model.ShortAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortAnswerRepository extends JpaRepository <ShortAnswer, Long>{
}
