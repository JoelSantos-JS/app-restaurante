package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.ProdutoDTO;
import com.br.joel.app.restaurante.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoMapper {

    @Autowired

    private ModelMapper mapper;


    public ProdutoDTO toProdutoDTO(Produto produto) {
        return mapper.map(produto, ProdutoDTO.class);
    }


    public List<ProdutoDTO> toProdutoDTO(List<Produto> produtos) {
        return produtos.stream().map(e -> toProdutoDTO(e)).toList();
    }
}
