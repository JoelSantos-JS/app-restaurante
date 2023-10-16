package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.model.ItemPedido;

import java.util.List;

public interface ItemPedidoImpl {
    List<ItemPedido> listar();
    ItemPedido buscar(Long id);
    ItemPedido salvar(ItemPedido itemPedido);
    ItemPedido atualizar(Long id, ItemPedido itemPedido);
    void remover(Long id);
}
