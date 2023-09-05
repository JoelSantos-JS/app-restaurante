package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.PermissaoDTO;
import com.br.joel.app.restaurante.model.Permissao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class PermissaoMapper {

    @Autowired
    private ModelMapper mapper;


    public PermissaoDTO  toDTO(Permissao permissao) {
        return mapper.map(permissao, PermissaoDTO.class);
    }

    public List<PermissaoDTO>  toDTO(Collection<Permissao> permissoes) {
        return permissoes.stream().map(this::toDTO).toList();
    }
}
