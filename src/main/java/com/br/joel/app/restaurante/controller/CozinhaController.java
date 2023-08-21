package com.br.joel.app.restaurante.controller;


import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.repository.CozinhaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {



    private  final CozinhaRepository cozinhaRepository;


    public CozinhaController(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    @GetMapping()

    public List<Cozinha> getAll() {
        return  cozinhaRepository.findAll();
    }
}
