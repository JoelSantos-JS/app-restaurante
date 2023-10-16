package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Cidade;
import com.br.joel.app.restaurante.model.Cozinha;

import java.util.List;

public interface CidadeImpl {
    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cozinha);
    Cidade atualizar(Long id, Cidade cozinha);
    void remover(Long id);
}
