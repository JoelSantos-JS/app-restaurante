package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.model.Estado;

import java.util.List;

public interface EstadoImpl {

    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado cozinha);
    Estado atualizar(Long id, Estado cozinha);
    void remover(Long id);
}
