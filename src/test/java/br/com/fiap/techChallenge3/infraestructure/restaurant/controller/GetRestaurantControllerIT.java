package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.utils.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class GetRestaurantControllerIT {

    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/restaurants/{id}";

    @BeforeAll
    public static void setUp() {
        CreateRestaurantControllerIT createRestaurantControllerIT = new CreateRestaurantControllerIT();
        createRestaurantControllerIT.shouldCreateRestaurantSucess();
    }

    @Test
    public void shouldGetRestaurantSuccessfully() {
        int restaurantId = 1;

          given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType( MediaType.APPLICATION_JSON_VALUE)
                .pathParam("id", restaurantId)
                .when()
                .get()
                .then()
                .statusCode( HttpStatus.OK.value())
                .body("location", equalTo("Industrial"))
                .body("cuisineType", equalTo("Brasileira"));
    }

}