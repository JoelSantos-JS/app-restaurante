package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.PedidoDTO;
import com.br.joel.app.restaurante.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {

    @Autowired
    private ModelMapper mapper;



    public PedidoDTO  toDTO(Pedido pedido) {

    return mapper.map(pedido, PedidoDTO.class);
    }


    public List<PedidoDTO> toDTO(List<Pedido> pedido) {

        return pedido.stream().map(this::toDTO).toList();

    }

}
