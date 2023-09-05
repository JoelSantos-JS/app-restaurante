package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.ProdutoDTO;
import com.br.joel.app.restaurante.mapper.ProdutoMapper;
import com.br.joel.app.restaurante.model.Produto;
import com.br.joel.app.restaurante.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {

    @Autowired
    private ProdutoServices  produtoServices;



    @Autowired
    private ProdutoMapper mapper;

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        final  var listar = produtoServices.listar();

        return  ResponseEntity.ok().body(listar);
    }

    @GetMapping
    (value = "/{id}")
    public ResponseEntity<ProdutoDTO> buscar(@PathVariable Long id) {
            final  var buscar = produtoServices.buscar(id);
        return  ResponseEntity.ok().body(mapper.toProdutoDTO(buscar));
    }

    @PostMapping

    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produtoDTO) {
        final  var cadastrar = produtoServices.salvar(produtoDTO);
        return  ResponseEntity.ok().body(cadastrar);
    }

    @PutMapping

    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id, @RequestBody Produto produtoDTO) {
        final var atualizar = produtoServices.atualizar(id, produtoDTO);
        return  ResponseEntity.ok().body(mapper.toProdutoDTO(atualizar));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoServices.remover(id);
        return  ResponseEntity.noContent().build();
    }

}
