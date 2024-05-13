package br.com.fiap.techChallenge3.infraestructure.customer;

import br.com.fiap.techChallenge3.entity.customer.model.Customer;
import br.com.fiap.techChallenge3.infraestructure.restaurant.CreateRestaurantControllerIT;
import br.com.fiap.techChallenge3.utils.Config;
import br.com.fiap.techChallenge3.utils.CustomerHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateCustomerControllerIT {

    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/customers";
    CustomerHelper customerHelper = new CustomerHelper();
    CreateRestaurantControllerIT createRestaurantControllerIT = new CreateRestaurantControllerIT();
    @BeforeAll
    public void setup(){

        //createRestaurantControllerIT.deveCriarRestaurantComSucesso();

    }
    @Test
    public void deveCriarCustomerComSucesso(){

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(generatorCustomer())
                .when()
                .post()
                .then()
                .statusCode( HttpStatus.CREATED.value())
                .body("id", not(empty()))
                .body("username", not(empty()))
                .body("name", not(empty()))
                .body("email", not(empty()))
                .body("phoneNumber", not(empty()));
    }

    //@Test
    public void deveValidarSchemaResponseCustomer(){

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(customerHelper.bodyRequestCustomer())
                .when()
                .post()
                .then()
                .statusCode( HttpStatus.CREATED.value())
                .body(matchesJsonSchemaInClasspath( "schema/customer-schema.json" ));
    }

    private Customer generatorCustomer(){

        Customer customer =  new Customer();
        customer.setUsername( "Pedro");
        customer.setPassword( "123456");
        customer.setName( "Alan");
        customer.setEmail( "teste@teste.com");
        customer.setCpf( "35598678421");
        customer.setPhoneNumber( "3196358472" );
        return customer;
    }
}