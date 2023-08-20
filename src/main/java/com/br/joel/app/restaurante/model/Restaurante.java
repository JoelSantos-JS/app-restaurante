package com.br.joel.app.restaurante.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
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

    private Instant  dataCadastro;
    private Instant  dataAtualizacao;

    @ManyToOne()
    @JoinColumn(name = "cozinha_id")
    private  Cozinha cozinha;


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
