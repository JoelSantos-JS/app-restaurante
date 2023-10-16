package com.br.joel.app.restaurante.mapper;

import com.br.joel.app.restaurante.DTO.GrupoDTO;
import com.br.joel.app.restaurante.DTO.UsuariosDTO;
import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.model.Usuario;
import com.br.joel.app.restaurante.model.input.UsuarioInput;
import com.br.joel.app.restaurante.model.input.UsuarioSenhaInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class UsuarioMapper {

    @Autowired
    private ModelMapper mapper;

    public UsuariosDTO toModell(Usuario usuario) {

        return  mapper.map(usuario, UsuariosDTO.class);
    }

    public List<UsuariosDTO>toModell(Collection<Usuario> usuarios) {
        return usuarios.stream().map(e -> toModell(e)).toList();
    }


    public Usuario  toInput(UsuarioInput input) {
        return  mapper.map(input, Usuario.class);
    }
    public UsuarioInput  toInput(Usuario usuario) {
        return  mapper.map(usuario, UsuarioInput.class);
    }

    public  Usuario toSenha (UsuarioSenhaInput input) {
        return  mapper.map(input, Usuario.class);
    }

    public UsuarioSenhaInput toSenha (Usuario usuario) {

        return  mapper.map(usuario, UsuarioSenhaInput.class);


    }
}
