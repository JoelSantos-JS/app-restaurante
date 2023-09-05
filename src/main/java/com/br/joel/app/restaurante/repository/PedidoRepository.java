package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
