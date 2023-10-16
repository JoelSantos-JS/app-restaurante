package com.br.joel.app.restaurante.controller;


import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.repository.CozinhaRepository;
import com.br.joel.app.restaurante.services.CozinhaServices;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {



    private  final CozinhaServices cozinhaServices;


    public CozinhaController(CozinhaServices  cozinhaServices) {
        this.cozinhaServices = cozinhaServices;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cozinha>> getAll() {
        final  var find = cozinhaServices.listar();
        return  ResponseEntity.ok().body(find);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Cozinha> buscarPorId(@PathVariable Long id) {
        final  var anId =cozinhaServices.buscar(id);

        if(anId == null) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok().body(anId);
    }

    @GetMapping(value = "/search")
    public  ResponseEntity<List<Cozinha>> buscarPorNome(@RequestParam(value = "nome", required = false) String nome) {
        return ResponseEntity.ok().body(cozinhaServices.buscarPorNome(nome));
    }


    @PostMapping
    public ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(cozinhaServices.salvar(cozinha));
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Cozinha> atualizar(@PathVariable Long id , @RequestBody Cozinha cozinha) {

        return  ResponseEntity.status(HttpStatus.OK).body(cozinhaServices.atualizar(id, cozinha));
    }


    @DeleteMapping(value = "/{id}")
    public void remover(@PathVariable Long id) {
        cozinhaServices.remover(id);
    }
}
