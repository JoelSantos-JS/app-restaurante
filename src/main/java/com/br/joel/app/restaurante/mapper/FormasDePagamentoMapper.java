package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.FormaDePagamentoDTO;
import com.br.joel.app.restaurante.model.FormaDePagamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class FormasDePagamentoMapper {


    @Autowired
     private  ModelMapper mapper;


    public FormaDePagamentoDTO  toFormaDePagamento(FormaDePagamento forma) {
        return mapper.map(forma, FormaDePagamentoDTO.class);
    }


    public  List<FormaDePagamentoDTO> toFormaDePagamento(Collection<FormaDePagamento> formas) {
        return formas.stream().map(e -> toFormaDePagamento(e)).toList();
    }
}
