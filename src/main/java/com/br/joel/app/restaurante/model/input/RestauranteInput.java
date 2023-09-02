package com.br.joel.app.restaurante.model.input;

import com.br.joel.app.restaurante.DTO.CozinhaDTO;
import com.br.joel.app.restaurante.Validation.TaxaFrete;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
public class RestauranteInput {
    @NotEmpty(message = "Nome do restaurante não pode ser vazio")
    @NotNull(message = "Nome do restaurante não pode ser nulo" )
    private  String nome;
    @DecimalMin("0")
    @TaxaFrete(message = "Taxa tem que ser maior que 0")
    private BigDecimal  taxaFrete;

    @Valid

    @JsonIgnoreProperties(value = "nome", allowGetters = true, allowSetters= true)
    private CozinhaIdInput   cozinha;

}
