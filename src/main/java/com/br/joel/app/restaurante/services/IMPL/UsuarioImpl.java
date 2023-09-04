package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.Usuario;

import java.util.List;

public interface UsuarioImpl {

    List<Usuario> listar();
    Usuario buscar(Long id);
    Usuario salvar(Usuario usuario);
    Usuario atualizar(Long id, Usuario usuario);
    void remover(Long id);
}
