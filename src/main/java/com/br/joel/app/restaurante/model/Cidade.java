package com.br.joel.app.restaurante.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.FetchType;

@Entity(name = "cidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cidades" )
public class Cidade {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private  String nome;

    @ManyToOne
    private  Estado estado;
}
