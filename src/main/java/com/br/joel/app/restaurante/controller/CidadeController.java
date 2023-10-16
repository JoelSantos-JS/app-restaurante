package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.model.Cidade;
import com.br.joel.app.restaurante.services.CidadeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {


    private  final CidadeServices  cidadeServices;

    public CidadeController(CidadeServices cidadeServices) {
        this.cidadeServices = cidadeServices;
    }


    @GetMapping
    public ResponseEntity<List<Cidade>> listar() {
        return ResponseEntity.ok(cidadeServices.listar());
    }

    @GetMapping
    (value = "/{id}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long id) {
    return ResponseEntity.ok(cidadeServices.buscar(id));
    }

    @PostMapping

    public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
        return ResponseEntity.ok(cidadeServices.salvar(cidade));
    }


    @PutMapping
    (value = "/{id}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @RequestBody Cidade cidade) {
        return ResponseEntity.ok(cidadeServices.atualizar(id, cidade));
    }

    @DeleteMapping
    (value = "/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        cidadeServices.remover(id);
        return ResponseEntity.noContent().build();
    }
}
