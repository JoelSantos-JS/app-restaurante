package com.br.joel.app.restaurante.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteDTO {


    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private  CozinhaDTO  cozinha;
    private  boolean ativo;
    private  boolean aberto;
    private  EnderecoDTO endereco;


}
