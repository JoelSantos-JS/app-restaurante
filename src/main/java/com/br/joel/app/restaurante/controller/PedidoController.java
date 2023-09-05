package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.PedidoDTO;
import com.br.joel.app.restaurante.mapper.PedidoMapper;
import com.br.joel.app.restaurante.model.Pedido;
import com.br.joel.app.restaurante.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServices  pedidoServices;


    @Autowired
    private PedidoMapper mapper;


    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listar(){
        final  var listar= pedidoServices.listar();
        return  ResponseEntity.ok().body(mapper.toDTO(listar));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id){
        final  var pedido= pedidoServices.buscar(id);

        return  ResponseEntity.ok().body(mapper.toDTO(pedido));
    }

    @PostMapping

    public ResponseEntity<PedidoDTO> salvar(@RequestBody  Pedido pedidoDTO){
        final  var pedido= pedidoServices.salvar(pedidoDTO);

        return  ResponseEntity.ok().body(mapper.toDTO(pedido));
    }


    @PutMapping
    (value = "id")
    public ResponseEntity<PedidoDTO> atualizar(@PathVariable Long id, @RequestBody Pedido pedidoDTO){
        final  var pedido= pedidoServices.atualizar(id,pedidoDTO);

        return  ResponseEntity.ok().body(mapper.toDTO(pedido));
    }

    @DeleteMapping
    (value = "id")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        pedidoServices.remover(id);
        return ResponseEntity.ok().build();
    }
}
