package com.br.joel.app.restaurante.model;


import com.br.joel.app.restaurante.Validation.TaxaFrete;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.util.*;

@Entity
@Data

@NoArgsConstructor
@Table
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome do restaurante não pode ser vazio")
    @NotNull(message = "Nome do restaurante não pode ser nulo" )
    @Column(nullable = false)
    private  String nome;
    private  boolean ativo;

    @DecimalMin("0")
    @TaxaFrete(message = "Taxa tem que ser maior que 0")
    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;
        @JsonIgnore
    @CreationTimestamp
    private Instant  dataCadastro ;
      @JsonIgnore
    @UpdateTimestamp()
    private Instant  dataAtualizacao ;

    @Valid
    @ManyToOne()
    @JsonIgnoreProperties(value = "nome", allowGetters = true, allowSetters= true)
    @JoinColumn(name = "cozinha_id", nullable = false)
    private  Cozinha cozinha;

    @Embedded
    private  Endereco endereco;

    private   Boolean aberto;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "restaurante_forma_pagamento", joinColumns = @JoinColumn  (name = "restaurante_id"), inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private Set<FormaDePagamento> formaDePagamentos=new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "restaurante_usuario", joinColumns = @JoinColumn  (name = "restaurante_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private  Set<Usuario> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "restaurante")
    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();


    public  Restaurante(final Long id ,  final String nome, final  Boolean ativo , final  BigDecimal taxaFrete , Cozinha cozinha  ){
        this.id =id;
        this.nome = nome;
        this.ativo = ativo;
        this.taxaFrete = taxaFrete;
        this.dataCadastro = Instant.now();
        this.dataAtualizacao = Instant.now();
        this.cozinha = cozinha;
    }

    public  void  ativar(){
        setAtivo(true);
    }
    public  void  desativar() {
        setAtivo(false);
    }

    public  void  aberto(){
        setAberto(true);
    }

    public  void  fechado() {
        setAberto(false);
    }


}
