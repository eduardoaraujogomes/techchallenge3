package br.com.fiap.techChallenge3.infraestructure.restaurant.controller;

import br.com.fiap.techChallenge3.utils.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeleteRestaurantControllerIT {
    private static final String BASE_URL = Config.getLocalhostUrl();
    private static final int PORT = Config.getLocalhostPort();
    private static final String BASE_PATH = "/restaurants/{id}";

    @BeforeAll
    public static void setUp() throws InterruptedException {
        CreateRestaurantControllerIT createRestaurantControllerIT = new CreateRestaurantControllerIT();
        createRestaurantControllerIT.shouldCreateRestaurantSucess();
    }

    @Test
    public void shouldDeleteRestaurantSuccess() {
        int restaurantId = 1;

        String responseBody = given()
                .baseUri(BASE_URL)
                .port(PORT)
                .basePath(BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .pathParam("id", restaurantId)
                .when()
                .delete()
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().asString();

        assertThat(responseBody, emptyString());
    }
}