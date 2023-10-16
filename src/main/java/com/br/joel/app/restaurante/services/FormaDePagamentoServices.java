package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.FormaDePagamento;
import com.br.joel.app.restaurante.repository.FormaDePagamentoRepository;
import com.br.joel.app.restaurante.services.IMPL.FormaDePagamentoImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormaDePagamentoServices implements FormaDePagamentoImpl {

    private  final FormaDePagamentoRepository  repository;


    @Autowired
    private ModelMapper mapper;

    public FormaDePagamentoServices(FormaDePagamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormaDePagamento> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public FormaDePagamento buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public FormaDePagamento salvar(FormaDePagamento formaDePagamento) {
        return repository.save(formaDePagamento);
    }

    @Override
    @Transactional()
    public FormaDePagamento atualizar(Long id, FormaDePagamento formaDePagamento) {
        FormaDePagamento formaDePagamento1 =  buscar(id);
        if(formaDePagamento1 == null){
            throw  new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST,"Forma de Pagamento não encontrada");
        }

        BeanUtils.copyProperties(formaDePagamento, formaDePagamento1, "id");
        return repository.save(formaDePagamento1);
    }



    @Override
    @Transactional()
    public void remover(Long id) {

        try {
        repository.deleteById(id);

        }catch (Exception e){
            throw new DataIntegrityViolationException(e.getMessage());
        }

    }
}
