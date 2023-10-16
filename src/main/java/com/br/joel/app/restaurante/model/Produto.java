package com.br.joel.app.restaurante.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "produto_nome")
    private  String nome;
    @Column(name = "produto_descricao")
    private  String descricao;
    @Column(name = "produto_preco")
    private  BigDecimal preco;
    @Column(name = "produto_ativo")
    private  Boolean ativo;

    @ManyToOne()
    @JoinColumn(name = "restaurante_id")
    private  Restaurante restaurante;



}
