package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante ,Long> {

;
}
