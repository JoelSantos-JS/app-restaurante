package com.br.joel.app.restaurante.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

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



}
