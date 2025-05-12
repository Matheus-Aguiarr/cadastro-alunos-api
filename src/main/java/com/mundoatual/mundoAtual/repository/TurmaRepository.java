package com.mundoatual.mundoAtual.repository;

import com.mundoatual.mundoAtual.model.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurmaRepository extends JpaRepository<TurmaModel, Long> {
    Optional<TurmaModel> findByName(String name);
}
