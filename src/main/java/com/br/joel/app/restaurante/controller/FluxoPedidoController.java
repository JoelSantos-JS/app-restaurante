package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.services.FluxoPedidoService;
import com.br.joel.app.restaurante.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos/{pedidoId}")
public class FluxoPedidoController {


    @Autowired
    private FluxoPedidoService  fluxoPedidoService;





    @PutMapping("/confirmacao")
    public ResponseEntity<Void> confirmar(@PathVariable  Long pedidoId){

        fluxoPedidoService.confirmar(pedidoId);

        return  ResponseEntity.noContent().build();

    }

    @PutMapping("/processando")
    public ResponseEntity<Void> processando(@PathVariable  Long pedidoId){

        fluxoPedidoService.processando(pedidoId);

        return  ResponseEntity.noContent().build();

    }
    @PutMapping("/cancelado")
    public ResponseEntity<Void> cancelado(@PathVariable  Long pedidoId){

        fluxoPedidoService.cancelar(pedidoId);

        return  ResponseEntity.noContent().build();

    }

}
