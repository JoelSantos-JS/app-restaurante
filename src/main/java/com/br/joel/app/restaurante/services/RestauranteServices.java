package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.model.Restaurante;
import com.br.joel.app.restaurante.repository.CozinhaRepository;
import com.br.joel.app.restaurante.repository.RestauranteRepository;
import com.br.joel.app.restaurante.services.IMPL.RestauranteImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
public class RestauranteServices implements RestauranteImpl {

    private  final RestauranteRepository repository;
    private  final CozinhaServices  cozinhaServices;

    public RestauranteServices(RestauranteRepository repository, CozinhaServices cozinhaServices) {
        this.repository = repository;

        this.cozinhaServices = cozinhaServices;
    }
    @Override
    public List<Restaurante> listar() {

        try {
            return repository.findAll();
        }catch (Exception e) {
            throw  new EntidadeNaoEncontradaException ( HttpStatus.BAD_REQUEST , "Não foi possível encontrar os restaurantes");
        }

    }

    @Override
    public Restaurante buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Restaurante salvar(Restaurante restaurante) {
            Long id = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaServices.buscar(id);

        if(cozinha == null ){
            throw new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST  ,"Cozinha não encontrada");
        }
        restaurante.setCozinha(cozinha);
        restaurante.setAtivo(true);

        return repository.save(restaurante);
    }

    @Override
    public Restaurante atualizar(Long id, Restaurante restaurante) {

        Restaurante restaurante1  = buscar(id);

        try {

            BeanUtils.copyProperties(restaurante, restaurante1, "id", "formaDePagamentos","endereco","dataCadastro");
            repository.save(restaurante1);
        }catch (Exception e) {
            throw  new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST , "Restaurante não encontrado");
        }

        return restaurante1;
    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }
}
