package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.FormaDePagamentoDTO;
import com.br.joel.app.restaurante.DTO.UsuariosDTO;
import com.br.joel.app.restaurante.mapper.RestauranteToModel;
import com.br.joel.app.restaurante.mapper.UsuarioMapper;
import com.br.joel.app.restaurante.model.Restaurante;
import com.br.joel.app.restaurante.services.RestauranteServices;
import com.br.joel.app.restaurante.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes/{id}/usuario")
public class RestauranteUsuario {

    @Autowired
    private UsuarioServices usuarioServices;
    @Autowired
    private RestauranteServices  restauranteServices;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private RestauranteToModel model;


    @GetMapping
    public ResponseEntity<List<UsuariosDTO>> listar(@PathVariable Long id) {
        Restaurante restaurante = restauranteServices.buscar(id);

        return ResponseEntity.ok(usuarioMapper.toModell(restaurante.getUsuarios()));
    }


    @DeleteMapping("/{usuarioId}")
    public  ResponseEntity<Void> desassociarRestaurante(@PathVariable Long id, @PathVariable Long usuarioId){
        restauranteServices.desvincularRestaurante(id, usuarioId);

        return  ResponseEntity.noContent().build();
    }
    @GetMapping("/{usuarioId}")
    public  ResponseEntity<Void> associarRestaurante(@PathVariable Long id, @PathVariable Long usuarioId){
        restauranteServices.associarRestaurante(id, usuarioId);

        return  ResponseEntity.noContent().build();
    }

}
