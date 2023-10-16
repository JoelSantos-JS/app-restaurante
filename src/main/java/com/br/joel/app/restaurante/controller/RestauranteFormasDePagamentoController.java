package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.FormaDePagamentoDTO;
import com.br.joel.app.restaurante.mapper.FormasDePagamentoMapper;
import com.br.joel.app.restaurante.mapper.RestauranteToModel;
import com.br.joel.app.restaurante.model.Restaurante;
import com.br.joel.app.restaurante.services.ProdutoServices;
import com.br.joel.app.restaurante.services.RestauranteServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "restaurante/{id}/formas-pagamentos")
public class RestauranteFormasDePagamentoController {
    private  final RestauranteServices restauranteServices;
    private  final RestauranteToModel restauranteToModel;

    private  final ProdutoServices  produtoServices;

    private  final FormasDePagamentoMapper mapper;

    public RestauranteFormasDePagamentoController(RestauranteServices restauranteServices, RestauranteToModel restauranteToModel, ProdutoServices produtoServices, FormasDePagamentoMapper mapper) {
        this.restauranteServices = restauranteServices;
        this.restauranteToModel = restauranteToModel;
        this.produtoServices = produtoServices;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity< List<FormaDePagamentoDTO>> listar(@PathVariable Long id) {
        Restaurante restaurante = restauranteServices.buscar(id);

        return ResponseEntity.ok(mapper.toFormaDePagamento(restaurante.getFormaDePagamentos()));
    }


    @DeleteMapping("/{FormaDePagamentoId}")
    public  ResponseEntity<Void> desassociar(@PathVariable Long id, @PathVariable Long FormaDePagamentoId){
        restauranteServices.desvincularFormaPagamento(id, FormaDePagamentoId);

        return  ResponseEntity.noContent().build();
    }
    @GetMapping("/{FormaDePagamentoId}")
    public  ResponseEntity<Void> associar(@PathVariable Long id, @PathVariable Long FormaDePagamentoId){
        restauranteServices.associarFormaPagamento(id, FormaDePagamentoId);

        return  ResponseEntity.noContent().build();
    }


}
