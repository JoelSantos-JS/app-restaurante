package com.br.joel.app.restaurante.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RestauranteResumoDTO {
    @NotNull
    private  Long id;
    private  String nome;
}
