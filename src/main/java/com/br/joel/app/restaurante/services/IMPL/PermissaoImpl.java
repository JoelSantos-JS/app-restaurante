package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.model.Permissao;

import java.util.List;

public interface PermissaoImpl {

    List<Permissao> listar();
    Permissao buscar(Long id);
    Permissao salvar(Permissao Permissao);
    Permissao atualizar(Long id, Permissao Permissao);
    void remover(Long id);
}
