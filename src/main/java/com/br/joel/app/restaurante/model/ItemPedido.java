package com.br.joel.app.restaurante.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private Integer  quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal precoTotal;

    private String observacao;
    @ManyToOne()
    private  Pedido pedido;

    @ManyToOne
    private  Produto produto;



    public void calcularPrecoTotal() {
        BigDecimal precoUnitario = this.getPrecoUnitario();
        Integer quantidade = this.getQuantidade();

        if (precoUnitario == null) {
            precoUnitario = BigDecimal.ZERO;
        }

        if (quantidade == null) {
            quantidade = 0;
        }

        this.setPrecoTotal(precoUnitario.multiply(new BigDecimal(quantidade)));
    }

}
