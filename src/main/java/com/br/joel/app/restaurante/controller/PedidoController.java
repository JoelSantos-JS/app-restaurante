package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.PedidoDTO;
import com.br.joel.app.restaurante.DTO.PedidoFilter;
import com.br.joel.app.restaurante.DTO.PedidoResumoDTO;
import com.br.joel.app.restaurante.mapper.PedidoMapper;
import com.br.joel.app.restaurante.model.Pedido;
import com.br.joel.app.restaurante.repository.PedidoRepository;
import com.br.joel.app.restaurante.services.PedidoServices;
import com.br.joel.app.restaurante.spec.PedidoSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServices  pedidoServices;

    @Autowired
    private PedidoRepository pedidoRepository;


    @Autowired
    private PedidoMapper mapper;


    @GetMapping(value = "/search/codigo/{codigo}")
    public ResponseEntity<PedidoDTO> buscarPorCodigo(@PathVariable(value = "codigo") String codigo) {
        final var pedido = pedidoServices.buscarPorCodigo(codigo);
        return ResponseEntity.ok().body(mapper.toDTO(pedido));
    }


    @GetMapping
    public ResponseEntity<List<PedidoResumoDTO>> listar(PedidoFilter pedidoFilter , Pageable pageable){
        final  var listar= mapper.toResumoDTO( pedidoRepository.findAll(PedidoSpecs.usandoFilto(pedidoFilter)) ,pageable );
        return  ResponseEntity.ok().body(listar);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id){
        final  var pedido= pedidoServices.buscar(id);

        return  ResponseEntity.ok().body(mapper.toDTO(pedido));
    }

    @PostMapping
    public ResponseEntity<PedidoResumoDTO> salvar(@RequestBody PedidoResumoDTO pedidoDTO){
        final  var pedido= pedidoServices.salvar(mapper.toEntity(pedidoDTO));

        return  ResponseEntity.ok().body(mapper.toResumoDTO(pedido));
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
