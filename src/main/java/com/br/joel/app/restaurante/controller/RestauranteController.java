package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.RestauranteDTO;
import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.mapper.RestauranteToModel;
import com.br.joel.app.restaurante.model.Restaurante;
import com.br.joel.app.restaurante.model.input.RestauranteInput;
import com.br.joel.app.restaurante.services.RestauranteServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {


    private  final RestauranteServices restauranteServices;

    public RestauranteController(RestauranteServices restauranteServices) {
        this.restauranteServices = restauranteServices;
    }


    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> listar() {
        final  var listar = restauranteServices.listar();

        return ResponseEntity.ok(RestauranteToModel.toModel(listar));

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<RestauranteDTO> buscarPorId(@PathVariable  Long id) {
        Restaurante restaurante = restauranteServices.buscar(id);
        return ResponseEntity.ok(RestauranteToModel.toModel(restaurante));
    }



    @PostMapping
    public ResponseEntity<RestauranteDTO> adicionar(@RequestBody @Valid RestauranteInput restaurante) {
        final  var salvar = restauranteServices.salvar(RestauranteToModel.toEntity(restaurante));
        try {
            return  ResponseEntity.ok().body(RestauranteToModel.toModel(salvar));
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().build();
        }
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<RestauranteDTO> atualizar(@PathVariable Long id, @RequestBody RestauranteInput restaurante) {
        final  var atualizar = restauranteServices.atualizar(id, RestauranteToModel.toEntity(restaurante));
        return ResponseEntity.ok().body(RestauranteToModel.toModel(atualizar));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        restauranteServices.remover(id);
        return ResponseEntity.noContent().build();
    }



}
