package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.repository.CozinhaRepository;
import com.br.joel.app.restaurante.services.IMPL.CozinhaImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CozinhaServices implements CozinhaImpl {


    private  final CozinhaRepository cz;

    public CozinhaServices(CozinhaRepository cz) {
        this.cz = cz;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cozinha> listar() {
        return cz.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cozinha buscar(Long id) {
        return cz.findById(id).get();
    }

    @Override
    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return cz.save(cozinha);
    }

    @Override
    @Transactional
    public Cozinha atualizar(Long id, Cozinha cozinha) {
        Cozinha cozinha1  = cz.findById(id).get();

        BeanUtils.copyProperties(cozinha, cozinha1, "id");

        return cz.save(cozinha1);

    }

    @Override
    @Transactional
    public void remover(Long id) {
   try {
        cz.deleteById(id);
   }catch (DataIntegrityViolationException e) {
       throw new DataIntegrityViolationException("Não é possível excluir uma cozinha que possui produtos");
   }

    }
}