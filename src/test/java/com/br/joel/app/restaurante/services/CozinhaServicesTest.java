package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.repository.CozinhaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest
@ActiveProfiles("test")
class CozinhaServicesTest {



    @Autowired
    private  CozinhaServices cozinhaServices;


    @Autowired
   private   CozinhaRepository  cozinhaRepository;

    @Test
    public  void should_Create_Cozinha() {
        final  var id = 1L;
        final var nome= "Chisena";

        Cozinha cozinha = new Cozinha();
        cozinha.setId(id);
        cozinha.setNome(nome);
        Assertions.assertEquals(0 , cozinhaRepository.count());
        cozinhaServices.salvar(cozinha);


        Assertions.assertEquals(1 , cozinhaRepository.count());

        Assertions.assertNotNull(cozinha.getId());
        Assertions.assertEquals(nome, cozinha.getNome());
        Assertions.assertEquals(id, cozinha.getId());
    }


    @Test

    public  void should_search_Cozinha() {
        final  var id = 1L;
        final var nome= "Chisena";

        Cozinha cozinha = new Cozinha();
        cozinha.setId(id);
        cozinha.setNome(nome);
        Assertions.assertEquals(0 , cozinhaRepository.count());
        cozinhaServices.salvar(cozinha);
        final var novoId = cozinhaServices.buscar(cozinha.getId()).getId();

        Assertions.assertEquals(1 , cozinhaRepository.count());


        Assertions.assertNotNull(cozinha.getId());

        Assertions.assertEquals(nome, cozinha.getNome());

        Assertions.assertEquals(novoId, cozinha.getId());


    }



    @Test
    public  void should_update_Cozinha() {
        final var id = 1L;
        final var nome = "Chisena";

        Cozinha cozinha = new Cozinha();

        cozinha.setId(id);
        cozinha.setNome(nome);

      final  var novaCozinha =  cozinhaServices.salvar(cozinha);

      novaCozinha.setNome("Brasileira");



      final var  novo = cozinhaServices.atualizar(1L , novaCozinha);

      Assertions.assertEquals("Brasileira", novo.getNome());
      Assertions.assertEquals(id, novo.getId());
      Assertions.assertEquals(nome, cozinha.getNome());

    }

}