package com.br.joel.app.restaurante.DTO;

import com.br.joel.app.restaurante.model.Estado;
import lombok.Data;

import javax.persistence.ManyToOne;
@Data
public class CidadeDTO {

    private Long id;
    private  String nome;

    private EstadoDTO estado;
}
