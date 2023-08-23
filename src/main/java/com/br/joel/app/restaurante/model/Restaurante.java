package com.br.joel.app.restaurante.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data

@NoArgsConstructor
@Table
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String nome;
    private  boolean ativo;
    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    @JsonIgnore
    private Instant  dataCadastro;
    @JsonIgnore
    private Instant  dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false)
    private  Cozinha cozinha;

    @ManyToMany
    @JoinTable(name = "restaurante_forma_pagamento")
    private List<FormaDePagamento> formaDePagamentos= new ArrayList<>();


    public  Restaurante(final Long id ,  final String nome, final  Boolean ativo , final  BigDecimal taxaFrete , Cozinha cozinha  ){
        this.id =id;
        this.nome = nome;
        this.ativo = ativo;
        this.taxaFrete = taxaFrete;
        this.dataCadastro = Instant.now();
        this.dataAtualizacao = Instant.now();
        this.cozinha = cozinha;
    }


}
