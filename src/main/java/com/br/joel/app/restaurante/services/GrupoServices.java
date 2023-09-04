package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.repository.GrupoRepository;
import com.br.joel.app.restaurante.services.IMPL.GrupoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GrupoServices implements GrupoImpl {

    @Autowired
    private GrupoRepository repository;
    @Override
    public List<Grupo> listar() {
        return repository.findAll();
    }

    @Override
    public Grupo buscar(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Grupo salvar(Grupo grupo) {
        return repository.save(grupo);
    }

    @Override
    public Grupo atualizar(Long id, Grupo grupo) {
        Grupo grupo1 = buscar(id);

        if(grupo1 == null) {
            throw  new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST, "id nao encontrado");
        }

        grupo1.setId(grupo.getId());
        grupo1.setNome(grupo.getNome());
        grupo1.setPermissoes(grupo.getPermissoes());

        repository.save(grupo1);
        return grupo1;
    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }
}
