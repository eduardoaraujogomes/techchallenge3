package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.utils.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SearchRestaurantControllerIT {

    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/restaurants";

    @BeforeAll
    public static void setUp() {
        CreateRestaurantControllerIT createRestaurantControllerIT = new CreateRestaurantControllerIT();
        createRestaurantControllerIT.shouldCreateRestaurantSucess();
        createRestaurantControllerIT.shouldCreateRestaurantSucess();
    }

    @Test
    public void shouldGetRestaurantAllSuccessfully() {

        given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get()
                .then()
                .statusCode( HttpStatus.OK.value())
                .body("$", hasSize(greaterThan(1)))
                .body("id", not(empty()))
                .body("location", not(empty()))
                .body("cuisineType", not(empty()));

    }
}