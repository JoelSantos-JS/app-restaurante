package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.FormaDePagamentoDTO;
import com.br.joel.app.restaurante.DTO.PermissaoDTO;
import com.br.joel.app.restaurante.mapper.GrupoMapper;
import com.br.joel.app.restaurante.mapper.PermissaoMapper;
import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.model.Permissao;
import com.br.joel.app.restaurante.model.Restaurante;
import com.br.joel.app.restaurante.services.GrupoServices;
import com.br.joel.app.restaurante.services.PermissaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/grupos/{id}/permissao")
public class PermissaoGrupoController {

    @Autowired
     private PermissaoServices permissaoServices;

    @Autowired
    GrupoServices  grupoServices;

    @Autowired
    private GrupoMapper  mapper;

    @Autowired
    private PermissaoMapper   mapper2;


    @GetMapping
    public ResponseEntity<List<PermissaoDTO>> listar(@PathVariable Long id) {
        Grupo grupo = grupoServices.buscar(id);

        return ResponseEntity.ok(mapper2.toDTO(grupo.getPermissoes()));
    }


    @DeleteMapping(value = "/{permissaoId}")
    public ResponseEntity<Void> deletar(@PathVariable Long id, @PathVariable Long permissaoId) {
        permissaoServices.removerPermissaoGrupo(id , permissaoId);


        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "/{permissaoId}")
    public ResponseEntity<Void> adicionar(@PathVariable Long id, @PathVariable Long permissaoId) {
        permissaoServices.adicionarPermissaoGrupo(id , permissaoId);


        return ResponseEntity.noContent().build();
    }

}
