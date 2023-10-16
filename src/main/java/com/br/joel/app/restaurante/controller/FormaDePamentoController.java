package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.FormaDePagamentoDTO;
import com.br.joel.app.restaurante.mapper.FormasDePagamentoMapper;
import com.br.joel.app.restaurante.model.FormaDePagamento;
import com.br.joel.app.restaurante.services.FormaDePagamentoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/formas-de-pagamento")
public class FormaDePamentoController {


    private  final FormaDePagamentoServices  formaDePagamentoServices;
    private  final FormasDePagamentoMapper mapper;

    public FormaDePamentoController(FormaDePagamentoServices formaDePagamentoServices, FormasDePagamentoMapper mapper) {
        this.formaDePagamentoServices = formaDePagamentoServices;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<FormaDePagamentoDTO>> listar(){
        final  var listar = formaDePagamentoServices.listar();
        return ResponseEntity.ok(mapper.toFormaDePagamento(listar));

    }
    @GetMapping("{id}")
    public  ResponseEntity<FormaDePagamentoDTO> buscarPorId(@PathVariable  Long id){
      final  var buscar = formaDePagamentoServices.buscar(id);
        return  ResponseEntity.ok(mapper.toFormaDePagamento(buscar));
    }

    @PostMapping
    public  ResponseEntity<FormaDePagamentoDTO> adicionar(@RequestBody @Valid FormaDePagamento formaDePagamentoInput){
        final  var adicionar1 = formaDePagamentoServices.salvar(formaDePagamentoInput);
        return  ResponseEntity.ok(mapper.toFormaDePagamento(adicionar1));
    }
    @PutMapping("{id}")

    public  ResponseEntity<FormaDePagamentoDTO> atualizar(@PathVariable Long id, @RequestBody FormaDePagamento formaDePagamentoInput){
        final  var atualizar = formaDePagamentoServices.atualizar(id, formaDePagamentoInput);
        return  ResponseEntity.ok(mapper.toFormaDePagamento(atualizar));
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<Void> remover(@PathVariable Long id){
        formaDePagamentoServices.remover(id);
        return  ResponseEntity.noContent().build();
    }
}
