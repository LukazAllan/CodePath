package br.com.codepath.api.repository;

import br.com.codepath.api.model.Option;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    Optional<Option> findById(@NonNull Long id);

    List<Option> findByQuestionId(Long questionId);
}
