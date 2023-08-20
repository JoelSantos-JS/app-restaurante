package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante ,Long> {
}
