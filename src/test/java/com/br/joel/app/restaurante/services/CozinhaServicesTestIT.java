package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.model.Cozinha;
import com.br.joel.app.restaurante.repository.CozinhaRepository;
import com.br.joel.app.restaurante.repository.RestauranteRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CozinhaServicesTestIT {
    @LocalServerPort
    private  int port;


    @Autowired
    private  CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository repository;


    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/cozinhas";
            delete_and_create();
    }
        @Test
    public  void  should_return_200_when_make_request(){
            given().when().get().then().body("nome" , Matchers.hasSize((int) cozinhaRepository.count()));
        }



         @Test
        public  void  should_return_201_when_make_request(){
            given().body("{\"nome\": \"teste\"}").when().contentType(ContentType.JSON).accept(ContentType.JSON).post().then().statusCode(HttpStatus.CREATED.value());

         }
      @Test
        public  void  should_return_when_consult_by_id(){
                given().pathParams("id",1).when().get("/{id}").then().body("nome", Matchers.equalTo("Brasileira"));
         }
   @Test
        public  void  should_return_badRequest_when_consult_by_id(){
                given().pathParams("id",20).when().get("/{id}").then().statusCode(HttpStatus.BAD_REQUEST.value());
         }







         public  void  delete_and_create() {

             Cozinha cozinha = new Cozinha();
             cozinha.setNome("Brasileira");
             cozinhaRepository.save(cozinha);

             Cozinha cozinha2 = new Cozinha();
             cozinha2.setNome("Japonesa");
             cozinhaRepository.save(cozinha2);

         }




    }



