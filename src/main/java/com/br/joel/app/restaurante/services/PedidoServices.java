package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.Pedido;
import com.br.joel.app.restaurante.repository.PedidoRepository;
import com.br.joel.app.restaurante.services.IMPL.PedidoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PedidoServices implements PedidoImpl {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscar(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido salvar(Pedido pedido1) {
        pedido1.setDataCancelamento(Instant.now());
        pedido1.setDataConfirmacao(Instant.now());
        pedido1.setDataEntrega(Instant.now());
        pedido1.setDataCriacao(Instant.now());
        return pedidoRepository.save(pedido1);
    }

    @Override
    public Pedido atualizar(Long id, Pedido pedido) {
        Pedido pedido1 = buscar(id);
        if(pedido1 == null ) {
            throw  new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST, "Pedido não encontrado");
        }

        pedido1.setEndereco(pedido.getEndereco());
        pedido1.setStatus(pedido.getStatus());
        pedido1.setValorTotal(pedido.getValorTotal());
        pedido1.setDataCancelamento(Instant.now());
        pedido1.setDataConfirmacao(Instant.now());
        pedido1.setDataEntrega(Instant.now());
        pedido1.setDataCriacao(Instant.now());
        pedido1.setRestaurante(pedido.getRestaurante());
        pedido1.setSubtotal(pedido.getSubtotal());
        pedido1.setTaxaFrete(pedido.getTaxaFrete());
        pedido1.setUsuario(pedido.getUsuario());
        pedido1.setFormaDePagamentos(pedido.getFormaDePagamentos());


        return pedidoRepository.save(pedido1);

    }

    @Override
    public void remover(Long id) {
        pedidoRepository.deleteById(id);
    }
}
