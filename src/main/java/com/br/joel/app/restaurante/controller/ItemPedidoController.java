package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.ItemPedidoDTO;
import com.br.joel.app.restaurante.mapper.ItemPedidoMapper;
import com.br.joel.app.restaurante.model.ItemPedido;
import com.br.joel.app.restaurante.services.ItemPedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {


    @Autowired
    private ItemPedidoServices  itemPedidoServices;

    @Autowired
    private ItemPedidoMapper itemPedidoMapper;



    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemPedidoDTO> buscarPorId(Long id) {
        return ResponseEntity.ok(itemPedidoMapper.toDTO(itemPedidoServices.buscar(id)));
    }

    @GetMapping
    public  ResponseEntity<List<ItemPedidoDTO>> buscarTodos() {
        return ResponseEntity.ok(itemPedidoMapper.toDTO(itemPedidoServices.listar()));
    }


    @PostMapping

    public  ResponseEntity<ItemPedidoDTO> salvar(ItemPedido itemPedidoDTO) {
        return ResponseEntity.ok(itemPedidoMapper.toDTO(itemPedidoDTO));
    }

    @PutMapping
    (value = "/{id}")
    public ResponseEntity<ItemPedidoDTO> atualizar(Long id, ItemPedido itemPedidoDTO) {
        return ResponseEntity.ok(itemPedidoMapper.toDTO(itemPedidoServices.atualizar(id, itemPedidoDTO)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remover(Long id) {
        itemPedidoServices.remover(id);
        return  ResponseEntity.noContent().build();
    }
}
