package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.model.Estado;
import com.br.joel.app.restaurante.repository.EstadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/estados")
@RestController
public class EstadoController {

    private  final EstadoRepository estadoRepository;

    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }


    @GetMapping()
    public List<Estado > getAll() {
        return  estadoRepository.findAll();
    }
}
