package br.com.codepath.api.repository;

import br.com.codepath.api.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
