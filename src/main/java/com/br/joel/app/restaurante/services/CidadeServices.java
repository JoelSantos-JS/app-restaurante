package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.Cidade;
import com.br.joel.app.restaurante.repository.CidadeRepository;
import com.br.joel.app.restaurante.services.IMPL.CidadeImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CidadeServices implements CidadeImpl {

    private  final  CidadeRepository repository;

    private  final  EstadoServices estadoServices;

    public CidadeServices(CidadeRepository repository, EstadoServices estadoServices) {
        this.repository = repository;
        this.estadoServices = estadoServices;
    }

    @Override
    public List<Cidade> listar() {
        return repository.findAll();
    }

    @Override
    public Cidade buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Não foi possível encontrar a cidade"));
    }

    @Override
    public Cidade salvar(Cidade cozinha) {
        final  var anId= cozinha.getEstado().getId();
        final var estado1 =estadoServices.buscar(anId);
        if(anId == null) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar o estado");
        }

        cozinha.setEstado(estado1);

        return repository.save(cozinha);
    }

    @Override
    public Cidade atualizar(Long id, Cidade cozinha) {
        Cidade  cozinha1 = buscar(id);
        BeanUtils.copyProperties(cozinha, cozinha1, "id");
        return repository.save(cozinha1);

    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }
}
