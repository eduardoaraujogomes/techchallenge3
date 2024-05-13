package br.com.fiap.techChallenge3.infraestructure.customer.controller;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.utils.Config;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.empty;

class UpdateCustomerControllerIT {

    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/customers/{id}";

    @Test
    public void shouldUpdateCustomerIdSuccessfully(){
        int customerId = 1;

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(generatorCustomerUpdate())
                .pathParam("id", customerId)
                .when()
                .put()
                .then()
                .statusCode( HttpStatus.OK.value())
                .body("id", not(empty()))
                .body("username", equalTo( "Pedro II" ))
                .body("phoneNumber", equalTo("3196358473"))
                .body("password", not(empty()))
                .body("email", not(empty()));

    }


    private Customer generatorCustomerUpdate(){

        Customer customer =  new Customer();
        customer.setUsername( "Pedro II");
        customer.setPassword( "654321");
        customer.setName( "Pedro Junior II");
        customer.setEmail( "teste123@teste.com");
        customer.setCpf( "35598678423");
        customer.setPhoneNumber( "3196358473" );
        return customer;
    }
}