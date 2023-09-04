package com.br.joel.app.restaurante.model.input;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
@Data
public class UsuarioInput {


    private  String nome;
    private  String email;

}
