package com.br.joel.app.restaurante.DTO;

import com.br.joel.app.restaurante.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private  Long id;

    private  String nome;
    private  String descricao;
    private BigDecimal preco;

    private  Boolean ativo;



    public  ProdutoDTO ( Produto produto){
        this.id= produto.getId();
        this.nome= produto.getNome();
        this.descricao= produto.getDescricao();
        this.preco= produto.getPreco();
        this.ativo= produto.getAtivo();
    }

}
