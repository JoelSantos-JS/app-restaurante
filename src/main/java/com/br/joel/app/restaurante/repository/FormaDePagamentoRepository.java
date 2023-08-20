package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.FormaDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long> {
}
