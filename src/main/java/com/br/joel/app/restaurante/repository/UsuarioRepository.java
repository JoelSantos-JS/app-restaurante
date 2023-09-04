package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario , Long> {
}
