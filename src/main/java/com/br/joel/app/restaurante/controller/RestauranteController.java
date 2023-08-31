package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.CozinhaDTO;
import com.br.joel.app.restaurante.DTO.RestauranteDTO;
import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.mapper.ToModel;
import com.br.joel.app.restaurante.model.Restaurante;
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

        return ResponseEntity.ok(ToModel.toModel(listar));

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<RestauranteDTO> buscarPorId(@PathVariable  Long id) {
        Restaurante restaurante = restauranteServices.buscar(id);
        return ResponseEntity.ok(ToModel.toModel(restaurante));
    }



    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody @Valid Restaurante restaurante) {
        final  var salvar = restauranteServices.salvar(restaurante);
        try {
            return  ResponseEntity.ok().body(ToModel.toModel(salvar));
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<RestauranteDTO> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        final  var atualizar = restauranteServices.atualizar(id, restaurante);
        return ResponseEntity.ok().body(ToModel.toModel(atualizar));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        restauranteServices.remover(id);
        return ResponseEntity.noContent().build();
    }



}
