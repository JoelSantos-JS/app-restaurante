package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.model.Restaurante;

import java.util.List;

public interface RestauranteImpl {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    Restaurante atualizar(Long id, Restaurante restaurante);
    void remover(Long id);

}
