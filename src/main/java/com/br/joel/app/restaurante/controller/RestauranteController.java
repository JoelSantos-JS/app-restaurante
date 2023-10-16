package com.br.joel.app.restaurante.controller;

import com.br.joel.app.restaurante.DTO.ProdutoDTO;
import com.br.joel.app.restaurante.DTO.RestauranteDTO;
import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.mapper.ProdutoMapper;
import com.br.joel.app.restaurante.mapper.RestauranteToModel;
import com.br.joel.app.restaurante.model.Produto;
import com.br.joel.app.restaurante.model.Restaurante;
import com.br.joel.app.restaurante.model.input.RestauranteInput;
import com.br.joel.app.restaurante.repository.ProdutoRepository;
import com.br.joel.app.restaurante.services.ProdutoServices;
import com.br.joel.app.restaurante.services.RestauranteServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {


    private  final RestauranteServices restauranteServices;
    private  final  RestauranteToModel restauranteToModel;

    private final ProdutoRepository repository;

    private  final ProdutoMapper mapper;
    private  final ProdutoServices produtoServices;

    public RestauranteController(RestauranteServices restauranteServices, RestauranteToModel restauranteToModel, ProdutoRepository repository, ProdutoMapper mapper, ProdutoServices produtoServices) {
        this.restauranteServices = restauranteServices;
        this.restauranteToModel = restauranteToModel;
        this.repository = repository;
        this.mapper = mapper;
        this.produtoServices = produtoServices;
    }


    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> listar() {
        final  var listar = restauranteServices.listar();

        return ResponseEntity.ok(restauranteToModel.toModel(listar));

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<RestauranteDTO> buscarPorId(@PathVariable  Long id) {
        Restaurante restaurante = restauranteServices.buscar(id);
        return ResponseEntity.ok(restauranteToModel.toModel(restaurante));
    }

    @GetMapping(value = "/{id}/produtos")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutosPorRestaurante(@PathVariable Long id) {
        Restaurante restaurante = restauranteServices.buscar(id);

        if (restaurante == null) {
            return ResponseEntity.notFound().build();
        }

         List<Produto> produtos = repository.findAtivosByRestaurante(restaurante).get();
        return ResponseEntity.ok(mapper.toProdutoDTO(produtos));
    }
    @GetMapping(value = "/{id}/produtos/{produtoId}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorRestauranteEProdutoId(@PathVariable Long id, @PathVariable Long produtoId) {
        Restaurante restaurante = restauranteServices.buscar(id);

        if (restaurante == null) {
            return ResponseEntity.notFound().build();
        }

        Optional<Produto> produtoOptional = restaurante.getProdutos().stream()
                .filter(produto -> produto.getId().equals(produtoId))
                .findFirst();

        if (produtoOptional.isPresent()) {
            ProdutoDTO produtoDTO = new ProdutoDTO(produtoOptional.get()); // Substitua "ProdutoDTO" pelo nome da sua classe DTO
            return ResponseEntity.ok(produtoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





    @PostMapping
    public ResponseEntity<RestauranteDTO> adicionar(@RequestBody @Valid RestauranteInput restaurante) {
        final  var salvar = restauranteServices.salvar(restauranteToModel.toEntity(restaurante));
        try {
            return  ResponseEntity.ok().body(restauranteToModel.toModel(salvar));
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().build();
        }
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<RestauranteDTO> atualizar(@PathVariable Long id, @RequestBody RestauranteInput restaurante) {
        final  var atualizar = restauranteServices.atualizar(id, restauranteToModel.toEntity(restaurante));
        return ResponseEntity.ok().body(restauranteToModel.toModel(atualizar));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        restauranteServices.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/ativar")
    public  ResponseEntity<Void> ativar(@PathVariable Long id) {
            restauranteServices.ativarRestaurante(id);

        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/ativacao")
    public  ResponseEntity<Void> ativacao(@RequestBody List<Long> ids) {
            restauranteServices.ativarRestaurante(ids);

        return  ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/aberto")
    public  ResponseEntity<Void> abrir(@PathVariable Long id) {
            restauranteServices.abrirRestaurante(id);

        return  ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/fechar")
    public  ResponseEntity<Void> fechar(@PathVariable Long id) {
            restauranteServices.fecharRestaurante(id);

        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/desativar")
    public  ResponseEntity<Void> desativar(@PathVariable Long id) {
            restauranteServices.inativarRestaurante(id);

        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/desativacao")
    public  ResponseEntity<Void> desativacao(@RequestBody List<Long> id) {
            restauranteServices.inativarRestaurante(id);

        return  ResponseEntity.noContent().build();
    }



}
