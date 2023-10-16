package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.ItemPedidoDTO;
import com.br.joel.app.restaurante.DTO.PedidoDTO;
import com.br.joel.app.restaurante.model.ItemPedido;
import com.br.joel.app.restaurante.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemPedidoMapper {


    @Autowired
    private ModelMapper mapper;



    public ItemPedidoDTO toDTO(ItemPedido pedido) {

        return mapper.map(pedido, ItemPedidoDTO.class);
    }


    public List<ItemPedidoDTO> toDTO(List<ItemPedido> pedido) {

        return pedido.stream().map(this::toDTO).toList();

    }
}
