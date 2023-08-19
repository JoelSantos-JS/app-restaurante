package com.br.joel.app.restaurante.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table()
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "nome")
    private  String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cozinha cozinha = (Cozinha) o;
        return Objects.equals(getId(), cozinha.getId()) && Objects.equals(getNome(), cozinha.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
