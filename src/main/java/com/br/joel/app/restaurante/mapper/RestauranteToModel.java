package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.CozinhaDTO;
import com.br.joel.app.restaurante.DTO.ProdutoDTO;
import com.br.joel.app.restaurante.DTO.RestauranteDTO;
import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.model.Restaurante;
import com.br.joel.app.restaurante.model.input.RestauranteInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RestauranteToModel {


    @Autowired
    private  ModelMapper  modelMapper;


    public    RestauranteDTO toModel(Restaurante restaurante) {

        return modelMapper.map(restaurante,RestauranteDTO.class);
    }



    public  List<RestauranteDTO> toModel(List<Restaurante> restaurantes) {
        return restaurantes.stream().map(e -> toModel(e)).toList();
    }


    public   Restaurante  toEntity(RestauranteInput input) {


        return modelMapper.map(input,Restaurante.class);
    }

    public  void  copyToEntity(Restaurante restaurante1, Restaurante restaurante) {
        modelMapper.map(restaurante,restaurante);
    }



}
