package com.br.joel.app.restaurante.services.IMPL;

import com.br.joel.app.restaurante.model.FormaDePagamento;

import java.util.List;

public interface FormaDePagamentoImpl {

    List<FormaDePagamento> listar();
    FormaDePagamento buscar(Long id);
    FormaDePagamento salvar(FormaDePagamento formaDePagamento);
    FormaDePagamento atualizar(Long id, FormaDePagamento formaDePagamento);
    void remover(Long id);
}
