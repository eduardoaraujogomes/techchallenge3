package br.com.fiap.techChallenge3.infraestructure.review.controller;

import br.com.fiap.techChallenge3.infraestructure.customer.controller.CreateCustomerControllerIT;
import br.com.fiap.techChallenge3.infraestructure.restaurant.controller.CreateRestaurantControllerIT;
import br.com.fiap.techChallenge3.utils.Config;
import br.com.fiap.techChallenge3.utils.ReviewHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CreateReviewControllerIT {
    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/reviews";
    ReviewHelper reviewHelper = new ReviewHelper();
    CreateRestaurantControllerIT createRestaurantControllerIT = new CreateRestaurantControllerIT();
    CreateCustomerControllerIT createCustomerControllerIT = new CreateCustomerControllerIT();

    @BeforeAll
    public void setup(){
        createCustomerControllerIT.deveCriarCustomerComSucesso();
    }

    @Test
    public void shouldCreateReviewSucess(){

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(reviewHelper.bodyRequestReview())
                .when()
                .post()
                .then()
                .statusCode( HttpStatus.CREATED.value())
                .body("id", not(empty()))
                .body("restaurant", not(empty()))
                .body("restaurant.id", not(empty()))
                .body("restaurant.name", not(empty()))
                .body("restaurant.location", not(empty()))
                .body("restaurant.cuisineType", not(empty()))
                .body("restaurant.openingHours", not(empty()))
                .body("restaurant.capacity", not(empty()))
                .body("customer", not(empty()))
                .body("customer.id", not(empty()))
                .body("customer.username", not(empty()))
                .body("customer.name", not(empty()))
                .body("customer.email", not(empty()))
                .body("customer.phoneNumber", not(empty()))
                .body("rating", not(empty()))
                .body("comment", not(empty()))
                .body("comment", equalTo("Muito Bom!"));
    }

    @Test
    public void shouldValidateSchemaResponseReview(){

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .body(reviewHelper.bodyRequestReview())
                .when()
                .post()
                .then()
                .statusCode( HttpStatus.CREATED.value())
                .body(matchesJsonSchemaInClasspath( "schema/review-schema.json" ));
    }
}