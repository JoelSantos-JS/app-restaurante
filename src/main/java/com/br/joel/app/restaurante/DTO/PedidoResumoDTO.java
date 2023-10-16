package com.br.joel.app.restaurante.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoResumoDTO {
    private  Long id;

    private EnderecoDTO endereco;

    private RestauranteResumoDTO restaurante;




    private FormaDePagamentoDTO formaDePagamentos;

    private List<ItemPedidoDTO> items = new ArrayList<>();
}
