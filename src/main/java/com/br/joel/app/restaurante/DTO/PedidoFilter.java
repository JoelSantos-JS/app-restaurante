package com.br.joel.app.restaurante.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

@Data

public class PedidoFilter {


    private  Long usuarioId;
    private  Long  restauranteId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant dataCriacaoInicio;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant dataCriacaoFim;
}
