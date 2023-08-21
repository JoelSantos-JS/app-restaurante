package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Cozinha;

import java.util.List;

public interface CozinhaImpl {

    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    Cozinha atualizar(Long id, Cozinha cozinha);
    void remover(Long id);

}
