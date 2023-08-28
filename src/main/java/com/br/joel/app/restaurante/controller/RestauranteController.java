package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
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
    public ResponseEntity<List<Restaurante>> listar() {

        return ResponseEntity.ok(restauranteServices.listar());

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable  Long id) {
        return ResponseEntity.ok(restauranteServices.buscar(id));
    }



    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody @Valid Restaurante restaurante) {
        try {
            return  ResponseEntity.ok().body(restauranteServices.salvar(restaurante));
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return ResponseEntity.ok().body(restauranteServices.atualizar(id, restaurante));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        restauranteServices.remover(id);
        return ResponseEntity.noContent().build();
    }
}
