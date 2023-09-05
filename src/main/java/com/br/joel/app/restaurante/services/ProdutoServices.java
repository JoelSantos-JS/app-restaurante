package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.model.Produto;
import com.br.joel.app.restaurante.repository.ProdutoRepository;
import com.br.joel.app.restaurante.services.IMPL.ProdutoImpl;
import org.springframework.beans.BeanUtils;
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
        return repository.findAll();
    }

    @Override
    public Produto buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Produto salvar(Produto produto) {

        return  repository.save(produto);
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        Produto produto1 = buscar(id);

        BeanUtils.copyProperties(produto, produto1, "id");

        return repository.save(produto1);

    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }
}
