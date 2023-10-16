package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade , Long> {
}
