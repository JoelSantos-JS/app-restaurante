package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> , JpaSpecificationExecutor<Pedido> {


    Optional<Pedido> findByCodigo(String codigo);

    List<Pedido> findAll();
  }
