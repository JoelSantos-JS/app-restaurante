package com.br.joel.app.restaurante.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
public class UsuariosDTO {

    private  Long id;
    private  String nome;
    private  String email;

    @JsonIgnore
    private  String senha;


}
