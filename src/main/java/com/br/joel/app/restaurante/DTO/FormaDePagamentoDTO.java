package com.br.joel.app.restaurante.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FormaDePagamentoDTO {
    @NotNull
    private  long id;
    private  String descricao;
}
