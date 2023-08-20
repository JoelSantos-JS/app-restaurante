package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
