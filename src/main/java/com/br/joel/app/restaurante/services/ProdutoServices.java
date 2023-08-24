package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.model.Produto;
import com.br.joel.app.restaurante.repository.ProdutoRepository;
import com.br.joel.app.restaurante.services.IMPL.ProdutoImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServices implements ProdutoImpl {

    private  final ProdutoRepository repository;

    public ProdutoServices(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    @Override
    public Produto buscar(Long id) {
        return null;
    }

    @Override
    public Produto salvar(Produto produto) {
        return null;
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        return null;
    }

    @Override
    public void remover(Long id) {

    }
}
