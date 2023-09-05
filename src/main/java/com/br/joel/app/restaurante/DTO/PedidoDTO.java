package com.br.joel.app.restaurante.DTO;

import com.br.joel.app.restaurante.model.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoDTO {

    private  Long id;

    private BigDecimal subtotal;
    private BigDecimal taxaFrete;
    private BigDecimal valorTotal;



    private StatusPedido status;


    private EnderecoDTO endereco;

    private RestauranteDTO restaurante;


    private UsuariosDTO usuario;


    private FormaDePagamentoDTO formaDePagamentos;
}
