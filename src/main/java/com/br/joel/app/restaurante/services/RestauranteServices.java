package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.model.Restaurante;
import com.br.joel.app.restaurante.repository.RestauranteRepository;
import com.br.joel.app.restaurante.services.IMPL.RestauranteImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestauranteServices implements RestauranteImpl {

    private  final RestauranteRepository repository;

    public RestauranteServices(RestauranteRepository repository) {
        this.repository = repository;

    }
    @Override
    public List<Restaurante> listar() {

        try {
            return repository.findAll();
        }catch (Exception e) {
            throw  new EntidadeNaoEncontradaException("Não foi possível encontrar os restaurantes");
        }

    }

    @Override
    public Restaurante buscar(Long id) {
        return null;
    }

    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return repository.save(restaurante);
    }

    @Override
    public Restaurante atualizar(Long id, Restaurante restaurante) {
        Restaurante restaurante1  = buscar(id);

        if (restaurante1 != null) {
            BeanUtils.copyProperties(restaurante, restaurante1, "id");
        }
        return restaurante1;
    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }
}
