package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.GrupoDTO;
import com.br.joel.app.restaurante.model.Grupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GrupoMapper {


    @Autowired
    private ModelMapper mapper;

    public GrupoDTO toModell(Grupo grupo) {

        return  mapper.map(grupo, GrupoDTO.class);
    }

    public List<GrupoDTO> toModell(List<Grupo> grupo) {
        return grupo.stream().map(e -> toModell(e)).toList();
    }
}
