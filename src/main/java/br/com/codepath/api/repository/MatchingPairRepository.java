package br.com.codepath.api.repository;

import br.com.codepath.api.model.MatchingPair;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchingPairRepository extends JpaRepository<MatchingPair, Long> {
    Optional<MatchingPair> findById(@NonNull Long id);

    List<MatchingPair> findByQuestionId(Long questionId);
}
