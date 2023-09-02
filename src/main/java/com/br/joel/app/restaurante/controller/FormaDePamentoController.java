package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.model.FormaDePagamento;
import com.br.joel.app.restaurante.services.FormaDePagamentoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/formas-de-pagamento")
public class FormaDePamentoController {


    private  final FormaDePagamentoServices  formaDePagamentoServices;

    public FormaDePamentoController(FormaDePagamentoServices formaDePagamentoServices) {
        this.formaDePagamentoServices = formaDePagamentoServices;
    }

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(formaDePagamentoServices.listar());

    }
    @GetMapping("{id}")
    public  ResponseEntity<?> buscarPorId(@PathVariable  Long id){
        return  ResponseEntity.ok(formaDePagamentoServices.buscar(id));
    }

    @PostMapping
    public  ResponseEntity<?> adicionar(@RequestBody @Valid FormaDePagamento formaDePagamentoInput){
        return  ResponseEntity.ok(formaDePagamentoServices.salvar(formaDePagamentoInput));
    }
    @PutMapping("{id}")

    public  ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody FormaDePagamento formaDePagamentoInput){
        return  ResponseEntity.ok(formaDePagamentoServices.atualizar(id, formaDePagamentoInput));
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<?> remover(@PathVariable Long id){
        formaDePagamentoServices.remover(id);
        return  ResponseEntity.noContent().build();
    }
}
