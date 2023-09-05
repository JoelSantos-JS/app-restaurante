package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.GrupoDTO;
import com.br.joel.app.restaurante.DTO.PermissaoDTO;
import com.br.joel.app.restaurante.mapper.GrupoMapper;
import com.br.joel.app.restaurante.mapper.UsuarioMapper;
import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.model.Usuario;
import com.br.joel.app.restaurante.services.GrupoServices;
import com.br.joel.app.restaurante.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{id}/grupo")
public class UsuarioGrupoController {

    @Autowired
    private GrupoServices grupoServices;

    @Autowired
    private UsuarioServices usuarioServices;


    @Autowired
    private GrupoMapper  mapper;

    @Autowired
    private UsuarioMapper usuarioMapper;





    @GetMapping
    public ResponseEntity<List<GrupoDTO>> listar(@PathVariable Long id) {
        Usuario usuario = usuarioServices.buscar(id);

        return ResponseEntity.ok(mapper.toModell(usuario.getGrupos()));
    }

    @DeleteMapping(value = "/{usuarioId}")
    public ResponseEntity<Void> deletar(@PathVariable Long id, @PathVariable Long usuarioId) {
        grupoServices.removerUsuario(id , usuarioId);


        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "/{usuarioId}")
    public ResponseEntity<Void> adicionar(@PathVariable Long id, @PathVariable Long usuarioId) {
        grupoServices.adicionarUsuario(id , usuarioId);


        return ResponseEntity.noContent().build();
    }






}
