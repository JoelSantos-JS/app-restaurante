package com.br.joel.app.restaurante.repository;

import com.br.joel.app.restaurante.model.Produto;
import com.br.joel.app.restaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("from Produto where restaurante.id = :restaurante and id = :produto")
    Optional<Produto> findById(@Param("restaurante") Long restauranteId,
                               @Param("produto") Long produtoId);

    @Query("from Produto p where p.ativo = true and p.restaurante = :restaurante")
    Optional<List<Produto>> findAtivosByRestaurante(Restaurante  restaurante);
}
