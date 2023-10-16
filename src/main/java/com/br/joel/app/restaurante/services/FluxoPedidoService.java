package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.model.Pedido;
import com.br.joel.app.restaurante.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class FluxoPedidoService {

    @Autowired
    private  PedidoServices  pedidoServices;

    @Transactional
    public  void   confirmar(Long id) {
        Pedido pedido = pedidoServices.buscar(id);

        if(!pedido.getStatus().equals(StatusPedido.CRIADO)){
            throw  new IllegalArgumentException("Pedido não pode ser confirmado.");
        }

        pedido.setStatus(StatusPedido.CONFIRMADO);
        pedido.setDataConfirmacao(Instant.now());
    }

    @Transactional
    public  void   cancelar(Long id) {
        Pedido pedido = pedidoServices.buscar(id);

        if(!pedido.getStatus().equals(StatusPedido.CRIADO) && pedido.getStatus().equals(StatusPedido.CANCELADO) && pedido.getStatus().equals(StatusPedido.CONFIRMADO)){
            throw  new IllegalArgumentException("Pedido não pode ser Cancelado.");
        }

        pedido.setStatus(StatusPedido.CANCELADO);
        pedido.setDataCancelamento(Instant.now());
    }
    @Transactional
    public  void   processando(Long id) {
        Pedido pedido = pedidoServices.buscar(id);

        if(!pedido.getStatus().equals(StatusPedido.CRIADO) && pedido.getStatus().equals(StatusPedido.CANCELADO) && pedido.getStatus().equals(StatusPedido.CONFIRMADO)){
            throw  new IllegalArgumentException("Pedido não pode ser Processado.");
        }

        pedido.setStatus(StatusPedido.PROCESSANDO);
        pedido.setDataCriacao(Instant.now());
    }

}
