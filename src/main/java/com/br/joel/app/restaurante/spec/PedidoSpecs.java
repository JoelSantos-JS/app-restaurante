package com.br.joel.app.restaurante.spec;

import com.br.joel.app.restaurante.DTO.PedidoFilter;
import com.br.joel.app.restaurante.model.Pedido;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class PedidoSpecs {


    public  static Specification<Pedido> usandoFilto(PedidoFilter filtro) {
        return  (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            if (filtro.getUsuarioId() != null) {
                predicates.add(builder.equal(root.get("usuario"), filtro.getUsuarioId()));
            }

            if(filtro.getRestauranteId() != null) {
                predicates.add(builder.equal(root.get("restaurante"), filtro.getRestauranteId()));
            }
            if(filtro.getDataCriacaoInicio() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("dataCriacao"), filtro.getDataCriacaoInicio()));
            }
            if(filtro.getDataCriacaoFim() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("dataCriacao"), filtro.getDataCriacaoFim()));
            }

            return  builder.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
        };


    }
}