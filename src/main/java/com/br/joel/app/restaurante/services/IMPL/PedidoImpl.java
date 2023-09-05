package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.model.Pedido;

import java.util.List;

public interface PedidoImpl {

    List<Pedido> listar();
    Pedido buscar(Long id);
    Pedido salvar(Pedido pedido);
    Pedido atualizar(Long id, Pedido pedido);
    void remover(Long id);
}
