package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.Estado;
import com.br.joel.app.restaurante.services.EstadoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/estados")
@RestController
public class EstadoController {


    private  final EstadoServices estadoServices;


    public EstadoController(EstadoServices estadoServices) {
        this.estadoServices = estadoServices;
    }


    @GetMapping
    public ResponseEntity<List<Estado>> listar() {
        return  ResponseEntity.ok(estadoServices.listar());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable  Long id) {
        return ResponseEntity.ok(estadoServices.buscar(id));
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Estado estado) {
        try {
            return ResponseEntity.ok().body(estadoServices.salvar(estado));
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long id, @RequestBody Estado estado) {
        return ResponseEntity.ok().body(estadoServices.atualizar(id, estado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        estadoServices.remover(id);
        return ResponseEntity.noContent().build();
    }
}
