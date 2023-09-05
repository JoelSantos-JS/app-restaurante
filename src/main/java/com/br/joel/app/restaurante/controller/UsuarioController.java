package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.UsuariosDTO;
import com.br.joel.app.restaurante.mapper.UsuarioMapper;
import com.br.joel.app.restaurante.model.Usuario;
import com.br.joel.app.restaurante.model.input.UsuarioInput;
import com.br.joel.app.restaurante.model.input.UsuarioSenhaInput;
import com.br.joel.app.restaurante.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServices services;


    @Autowired
    private UsuarioMapper mapper;



    @GetMapping

    public ResponseEntity<List<UsuariosDTO>> listAlL() {
        final  var list = services.listar();

        return  ResponseEntity.ok().body(mapper.toModell(list));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuariosDTO> findById(@PathVariable Long id) {
        final  var getBY =  services.buscar(id);
        return ResponseEntity.ok().body(mapper.toModell(getBY));
    }


    @PostMapping

    public ResponseEntity<UsuariosDTO> create(@RequestBody Usuario usuario) {
        final  var create =  services.salvar(usuario);
        return ResponseEntity.ok().body(mapper.toModell(create));
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioInput> update(@PathVariable Long id, @RequestBody UsuarioInput usuario) {
        final  var update =  services.atualizar(id, mapper.toInput(usuario));
        return ResponseEntity.ok().body(mapper.toInput(update));
    }

    @PutMapping(value = "/{id}/senha")
    public ResponseEntity<UsuarioSenhaInput> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaInput usuario) throws Exception {
        final  var update =  services.atualizarSenha(id, usuario);
        mapper.toSenha(update);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.remover(id);

        return  ResponseEntity.noContent().build();
    }
}
