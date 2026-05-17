package br.com.codepath.api.repository;

import br.com.codepath.api.model.Streak;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StreakRepository extends JpaRepository<Streak, Long> {
    Optional<Streak> findById(@NonNull Long id);
    List<Streak> findAllByDays(Integer days);
    Optional<Streak> findByUserId(Long userId);
}
