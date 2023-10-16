package com.br.joel.app.restaurante.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String codigo = UUID.randomUUID().toString();

    private BigDecimal subtotal;
    private BigDecimal taxaFrete;
    private BigDecimal valorTotal;
    @CreationTimestamp
    private Instant dataCriacao;
    private Instant dataConfirmacao;
    private Instant dataCancelamento;
    private Instant dataEntrega;

    @Enumerated(EnumType.STRING)
    private   StatusPedido status = StatusPedido.CRIADO;

    @Embedded
    private  Endereco endereco;

    @ManyToOne()
    private  Restaurante restaurante;

    @ManyToOne()
    private  Usuario usuario;



    @ManyToOne
    private  FormaDePagamento formaDePagamentos;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> items = new ArrayList<>();



    public void calcularPrecoFinal() {
        getItems().forEach(ItemPedido::calcularPrecoTotal);

        this.subtotal = getItems().stream()
                .map(item -> item.getPrecoTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.valorTotal = this.subtotal.add(this.taxaFrete);
    }




}
