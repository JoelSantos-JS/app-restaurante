package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
}
