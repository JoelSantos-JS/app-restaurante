package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.PermissaoDTO;
import com.br.joel.app.restaurante.mapper.PermissaoMapper;
import com.br.joel.app.restaurante.model.Permissao;
import com.br.joel.app.restaurante.services.PermissaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

    @Autowired
    private PermissaoServices services;



    @Autowired
    private PermissaoMapper mapper;


    @GetMapping
    public ResponseEntity<List<PermissaoDTO>> listar() {
        final  var listar = services.listar();
        return ResponseEntity.ok(mapper.toDTO(listar));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PermissaoDTO> listarPorId(@PathVariable Long id) {
            final  var listar = services.buscar(id);
        return ResponseEntity.ok(mapper.toDTO(listar));
    }

    @PostMapping

    public ResponseEntity<PermissaoDTO> cadastrar(@RequestBody Permissao dto) {
        final  var cadastrar = services.salvar(dto);
        return ResponseEntity.ok(mapper.toDTO(cadastrar));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PermissaoDTO> atualizar(@PathVariable Long id, @RequestBody Permissao dto) {
        final  var atualizar = services.atualizar(id, dto);

        return ResponseEntity.ok(mapper.toDTO(atualizar));

    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        services.remover(id);
        return ResponseEntity.noContent().build();
    }
}
