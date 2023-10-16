package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.DTO.PedidoFilter;
import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.*;
import com.br.joel.app.restaurante.repository.ItemPedidoRepository;
import com.br.joel.app.restaurante.repository.PedidoRepository;
import com.br.joel.app.restaurante.services.IMPL.PedidoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServices implements PedidoImpl {

    @Autowired
    private PedidoRepository pedidoRepository;


    @Autowired
    private  CidadeServices cidadeServices;
    @Autowired
    private  ProdutoServices produtoServices;

    @Autowired
    private  FormaDePagamentoServices formaDePagamentoServices;
    @Autowired
    private  RestauranteServices restauranteServices;

    @Autowired
    private  ItemPedidoServices itemPedidoServices;
    @Autowired
    private  UsuarioServices usuarioServices;

    @Override
    public List<Pedido> listar(PedidoFilter pedidoFilter) {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscar(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }


    public  Pedido buscarPorCodigo(String codigo) {

        return  pedidoRepository.findByCodigo(codigo).get();
    }
    @Override
    public Pedido salvar(Pedido pedido1) {
        Usuario usuario = usuarioServices.buscar((long)2);

        validarPedido(pedido1);

        pedido1.setDataCriacao(Instant.now());
        pedido1.setUsuario(usuario);
        pedido1.setTaxaFrete(pedido1.getRestaurante().getTaxaFrete());


        validarEAtualizarItens(pedido1);




        return         pedidoRepository.save(pedido1);
    }

    private void validarPedido(Pedido pedido) {
        Cidade cidade = cidadeServices.buscar(pedido.getEndereco().getCidade().getId());
        Restaurante restaurante = restauranteServices.buscar(pedido.getRestaurante().getId());
        FormaDePagamento formaPagamento = formaDePagamentoServices.buscar(pedido.getFormaDePagamentos().getId());

        pedido.getEndereco().setCidade(cidade);
        pedido.setRestaurante(restaurante);
        pedido.setFormaDePagamentos(formaPagamento);

    }





    public List<ItemPedido> validarEAtualizarItens(Pedido pedido) {
        List<ItemPedido> itensPedidoAtualizados = new ArrayList<>();

        for (ItemPedido itemPedido : pedido.getItems()) {
            // 1. Validação de item (exemplo: verificar se a quantidade é maior que zero)
            if (itemPedido.getQuantidade() <= 0) {
                // Aqui você pode tratar a validação, lançar uma exceção ou fazer algo apropriado.
                // Por exemplo, lançar uma exceção:
                throw new IllegalArgumentException("Quantidade inválida para o item: " + itemPedido.getProduto().getNome());
            }

            // 2. Atualização do produto associado ao item


            // 3. Definir o pedido atual no item
            itemPedido.setPedido(pedido);

            // 4. Adicionar o item atualizado à lista de itens atualizados
            itensPedidoAtualizados.add(itemPedido);
        }

        // 5. Retornar a lista de itens atualizados
        return itensPedidoAtualizados;
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
