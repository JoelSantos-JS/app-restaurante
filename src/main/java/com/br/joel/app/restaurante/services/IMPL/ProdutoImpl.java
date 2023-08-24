package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Produto;

import java.util.List;

public interface ProdutoImpl {

        List<Produto> listar();

    Produto buscar(Long id);
    Produto salvar(Produto produto);
    Produto atualizar(Long id, Produto produto);
    void remover(Long id);
}
