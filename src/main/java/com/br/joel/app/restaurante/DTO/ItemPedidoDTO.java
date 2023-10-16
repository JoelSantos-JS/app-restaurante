package com.br.joel.app.restaurante.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
public class ItemPedidoDTO {

    private  long id;
    @NotEmpty
    private Integer  quantidade;

    private String observacao;
}
