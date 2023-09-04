package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Grupo;

import java.util.List;

public interface GrupoImpl {

    List<Grupo> listar();
    Grupo buscar(Long id);
    Grupo salvar(Grupo grupo);
    Grupo atualizar(Long id, Grupo grupo);
    void remover(Long id);
}
