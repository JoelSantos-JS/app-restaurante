package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.PedidoDTO;
import com.br.joel.app.restaurante.DTO.PedidoResumoDTO;
import com.br.joel.app.restaurante.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public PedidoResumoDTO  toResumoDTO(Pedido pedido) {

        return  mapper.map(pedido, PedidoResumoDTO.class);
    }

    public  Pedido  toEntity(PedidoResumoDTO pedidoDTO) {
        return  mapper.map(pedidoDTO, Pedido.class);
    }


    public List<PedidoResumoDTO> toResumoDTO(List<Pedido> pedido, Pageable pageable) {
        return pedido.stream().map(this::toResumoDTO).toList();
    }
}
