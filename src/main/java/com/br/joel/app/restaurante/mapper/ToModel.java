package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.CozinhaDTO;
import com.br.joel.app.restaurante.DTO.RestauranteDTO;
import com.br.joel.app.restaurante.model.Restaurante;

import java.util.List;

public class ToModel {


    public  static RestauranteDTO toModel(Restaurante restaurante) {
        CozinhaDTO cozinhaDTO = new CozinhaDTO();
        cozinhaDTO.setId(restaurante.getCozinha().getId());
        cozinhaDTO.setNome(restaurante.getCozinha().getNome());

        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNome(restaurante.getNome());
        restauranteDTO.setTaxaFrete(restaurante.getTaxaFrete());
        restauranteDTO.setCozinha(cozinhaDTO);

        return  restauranteDTO;
    }

    public static List<RestauranteDTO> toModel(List<Restaurante> restaurantes) {
        return restaurantes.stream().map(e -> toModel(e)).toList();
    }



}
