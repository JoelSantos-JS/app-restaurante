package com.br.joel.app.restaurante.DTO;

import com.br.joel.app.restaurante.model.Cidade;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
public class EnderecoDTO {

    private  String cep;
    private  String numero;
    private  String logradouro;
    private  String complemento;
    private  String bairro;

    private CidadeDTO cidade;
}
