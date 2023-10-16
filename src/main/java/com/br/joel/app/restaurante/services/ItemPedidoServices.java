package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.model.ItemPedido;
import com.br.joel.app.restaurante.repository.ItemPedidoRepository;
import com.br.joel.app.restaurante.services.IMPL.ItemPedidoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemPedidoServices implements ItemPedidoImpl {

    @Autowired
    private ItemPedidoRepository  itemPedidoRepository;
    @Override
    public List<ItemPedido> listar() {
        return itemPedidoRepository.findAll();
    }

    @Override
    public ItemPedido buscar(Long id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public ItemPedido salvar(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    @Override
    public ItemPedido atualizar(Long id, ItemPedido itemPedido) {
        ItemPedido  itemPedidoDB = buscar(id);

        itemPedidoDB.setObservacao(itemPedido.getObservacao());
        itemPedidoDB.setQuantidade(itemPedido.getQuantidade());
        itemPedidoDB.setPrecoUnitario(itemPedido.getPrecoUnitario());
        itemPedidoDB.setQuantidade(itemPedido.getQuantidade());

        itemPedidoRepository.save(itemPedidoDB);

        return itemPedidoDB;
    }

    @Override
    public void remover(Long id) {
    itemPedidoRepository.deleteById(id);
    }
}
