package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findByNomeContaining(String nome);
}
