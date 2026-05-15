package br.com.codepath.api.repository;

import br.com.codepath.api.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findByHash(String hash);
}