package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.GrupoDTO;
import com.br.joel.app.restaurante.mapper.GrupoMapper;
import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.services.GrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.TabExpander;
import java.util.List;

@RestController
@RequestMapping(value = "grupos")
public class GrupoController {

    @Autowired
    private GrupoServices grupoServices;

    @Autowired
    private GrupoMapper mapper;


    @GetMapping
    public ResponseEntity<List<GrupoDTO>> listAlL() {
        final  var listar = mapper.toModell(grupoServices.listar());
        return ResponseEntity.ok().body(listar);
    }

    @GetMapping("{id}")
    public  ResponseEntity<GrupoDTO> getById(@PathVariable long id) {
        final  var getBy = mapper.toModell(grupoServices.buscar(id));

        return  ResponseEntity.ok().body(getBy);
    }

    @PostMapping
    public  ResponseEntity<GrupoDTO>  save(@RequestBody Grupo grupo) {
        final  var salvar = mapper.toModell(grupoServices.salvar(grupo));

        return  ResponseEntity.ok().body(salvar);
    }

    @PutMapping("{id}")
    public  ResponseEntity<GrupoDTO> update(@PathVariable Long id, @RequestBody Grupo grupo) {
        final  var atualizar = mapper.toModell(grupoServices.atualizar(id, grupo));

        return ResponseEntity.ok().body(atualizar);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        grupoServices.remover(id);
        return  ResponseEntity.noContent().build();
    }
}
