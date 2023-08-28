package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.Estado;
import com.br.joel.app.restaurante.repository.EstadoRepository;
import com.br.joel.app.restaurante.services.IMPL.EstadoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EstadoServices implements EstadoImpl {
    private  final EstadoRepository repository;

    public EstadoServices(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Estado> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Estado buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST ,  "Estado não encontrado"));
    }

    @Override
    @Transactional()
    public Estado salvar(Estado cozinha) {
        return repository.save(cozinha);
    }

    @Override
    @Transactional()
    public Estado atualizar(Long id, Estado cozinha) {
        Estado  cozinha1  = buscar(id);

        BeanUtils.copyProperties(cozinha, cozinha1, "id");
        return repository.save(cozinha1);


    }

    @Override
    public void remover(Long id) {
    repository.deleteById(id);
    }
}
